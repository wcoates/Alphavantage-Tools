package Demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alphavantage.client.AlphaVantageClient;
import alphavantage.client.functions.Function;

public class Demo {
	private static final Logger Logger = LoggerFactory.getLogger(AlphaVantageClient.class);

	public static void main(String[] args) {
		String key = "U7TMSV7OKXIVJXP6";
		try {
			AlphaVantageClient client = new AlphaVantageClient(key);
			client.setDatatype("csv");
			client.setInterval("5min");

			System.out.println(client.getTimeSeriesResult("CERN", Function.TimeSeries.DAILY).getQuoteList()
					.getStockQuotes().get(0));

		} catch (Exception e) {
			Logger.error(e.getMessage());
		}

	}

}
