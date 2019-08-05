package com.ericroca.springbootdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.http.HttpHeaders.USER_AGENT;

@SpringBootApplication
@RestController
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(value = "/fetch2")
	public String fetch() {
		String token = "4dd1423b24764e8d9057c1bce8cdce18";
		String url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=71ef08b523a231385d9b8083d2e2ec3d";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

//		request.addHeader("User-Agent", USER_AGENT);
//		request.addHeader("Accept", "application/json");

		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (response.getStatusLine().getStatusCode() == 401) {
			String error = "The server did not respond properly. Check authorization token.";
			throw new RuntimeException(error);
		} else if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Something went wrong.");
		}

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		try {
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return String.valueOf(result);
	}

	@RequestMapping(value = "/fetch")
	public String javaFetch() {
		StringBuffer result = new StringBuffer();
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?id=681290&APPID=71ef08b523a231385d9b8083d2e2ec3d");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return String.valueOf(result);
	}
}