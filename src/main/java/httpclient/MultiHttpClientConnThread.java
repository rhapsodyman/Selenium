package httpclient;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class MultiHttpClientConnThread extends Thread {
	private CloseableHttpClient client;
	private HttpGet get;

	public MultiHttpClientConnThread(CloseableHttpClient client, HttpGet get) {
		this.client = client;
		this.get = get;
	}

	// standard constructors
	public void run() {
		try {

			System.out.println("Started will wait 10 seconds");
			Thread.sleep(10000);

			HttpResponse response = client.execute(get);
			EntityUtils.consume(response.getEntity());
		} catch (ClientProtocolException ex) {
		} catch (IOException ex) {
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static class SomeClass{
		public String name;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> first = new ArrayList<String>();
		
		SomeClass  someClass = new SomeClass();
		//someClass.name = "Andrey";
		first.add("Andrey");
		
		ArrayList<String> second = new ArrayList<String>(first);
		//second.set(0, "Alex");
		System.out.println(first.get(0));
		System.out.println(second.get(0));
		
	}
}