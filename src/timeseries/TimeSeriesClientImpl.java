
package timeseries;

import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import client.AdvantageClient;
import timeseries.model.Quote;
import timeseries.model.TimeSeries;

public class TimeSeriesClientImpl extends AdvantageClient implements TimeSeriesClient {
	final private static Logger Logger = LoggerFactory.getLogger(TimeSeriesClientImpl.class);

	private static String secret;

	public TimeSeriesClientImpl(String secretKey) {
		TimeSeriesClientImpl.secret = secretKey;
	}

	public TimeSeries getTimeSeriesData(timeseries.TimeSeriesClient.TimeSeriesTypes seriesType,
			String stockTicker) throws Exception {
		TimeSeries timeSeries = null;
		String responseBody;
		HttpGet httpGet = new HttpGet(baseURI + "&function=" + seriesType.toString() + "&symbol=" + stockTicker
				+ "&interval=5min" + "&apikey=" + secret + "&datatype=csv");

		Logger.info("Retrieving {} time series data for stock {}.", seriesType, stockTicker);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			HttpEntity entity = response.getEntity();
			responseBody = EntityUtils.toString(response.getEntity());
			EntityUtils.consume(entity);
			List<CSVRecord> list = CSVParser.parse(responseBody, CSVFormat.RFC4180).getRecords();
			timeSeries = Helper.convertCsvRecordsToTimeSeries(list);
		} catch (Exception e) {
			Logger.error(e.getMessage() + "\nCould not retrieve time series data.");
		} finally {
			response.close();
		}

		return timeSeries;
	}

	private static class Helper {
		final static private TimeSeries convertCsvRecordsToTimeSeries(List<CSVRecord> records) {
			TimeSeries timeSeries = new TimeSeries();
			Quote quote;

			for (CSVRecord record : records) {
				quote = new Quote();
				quote.setTimestamp(record.get(0));
				quote.setOpen(record.get(1));
				quote.setHigh(record.get(2));
				quote.setLow(record.get(3));
				quote.setClose(record.get(4));
				quote.setVolume(record.get(5));
				timeSeries.addQuote(quote);
			}
			// Remove header row
			timeSeries.removeQuote(0);

			return timeSeries;
		}
	}
}
