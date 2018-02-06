package client;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public abstract class AdvantageClient {
	public static final String baseURI = "https://www.alphavantage.co/query?";
	public static String secret;
	public static final CloseableHttpClient httpclient = HttpClients.createDefault();
}
