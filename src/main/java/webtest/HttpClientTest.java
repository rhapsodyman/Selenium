package webtest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientTest {
	
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		
		CloseableHttpClient client2 = HttpClientBuilder.create().build();
		
		System.out.println(client);
		System.out.println(client2);
		
		
		
		
	}
}
