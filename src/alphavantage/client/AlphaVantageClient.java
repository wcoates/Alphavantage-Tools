package alphavantage.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alphavantage.client.functions.Function;
import alphavantange.client.model.TimeSeriesResult;

public class AlphaVantageClient {
	private static final Logger Logger = LoggerFactory.getLogger(AlphaVantageClient.class);

	private final CloseableHttpClient httpclient = HttpClients.createDefault();
	private String interval;
	private String datatype;
	private String key;

	public AlphaVantageClient(String key) {
		this.key = key;
	}

	private final HttpGet buildGet(String stockTicker, String function) {
		AlphaVantageUrl.Builder builder = new AlphaVantageUrl.Builder();
		AlphaVantageUrl url = builder.functionValue(function).symbolValue(stockTicker).intervalValue(interval)
				.keyValue(key).datatypeValue(datatype).build();

		return new HttpGet(url.toString());
	}

	public final TimeSeriesResult getTimeSeriesResult(String stockTicker, Function.TimeSeries function)
			throws Exception {
		String responseBody;
		TimeSeriesResult timeSeriesResult = null;

		CloseableHttpResponse response = httpclient.execute(buildGet(stockTicker, function.toString()));

		try {
			HttpEntity entity = response.getEntity();
			responseBody = EntityUtils.toString(response.getEntity());
			EntityUtils.consume(entity);
			timeSeriesResult = TimeSeriesResult.buildResult(responseBody);
		} catch (Exception e) {
			Logger.error(e.getMessage() + "\nCould not retrieve data.");
		} finally {
			response.close();
		}

		return timeSeriesResult;
	}

	public final void setInterval(String interval) {
		this.interval = interval;
	}

	public final void setDatatype(String datatype) {
		this.datatype = datatype;
	}
}
