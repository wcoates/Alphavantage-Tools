package alphavantange.client.model;

import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Contains a time series result for a given interval defined in
 * {@link Function.TimeSeries}.
 */

public class TimeSeriesResult {
	private QuoteList quotes;

	private TimeSeriesResult(QuoteList quotes) {
		this.quotes = quotes;
	}

	public static final TimeSeriesResult buildResult(String csv) throws IOException {
		CSVParser records = CSVParser.parse(csv, CSVFormat.RFC4180);
		QuoteList quoteList = new QuoteList();
		Quote quote;

		for (CSVRecord record : records) {
			quote = new Quote();
			quote.setTimestamp(record.get(0));
			quote.setOpen(record.get(1));
			quote.setHigh(record.get(2));
			quote.setLow(record.get(3));
			quote.setClose(record.get(4));
			quote.setVolume(record.get(5));
			quoteList.addQuote(quote);
		}
		// Remove header row
		quoteList.removeQuote(0);

		return new TimeSeriesResult(quoteList);
	}

	public final QuoteList getQuoteList() {
		return quotes;
	}

	@Override
	public String toString() {
		return "TimeSeriesResult []";
	}
}
