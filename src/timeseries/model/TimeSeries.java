package timeseries.model;

import java.util.ArrayList;
import java.util.List;

public class TimeSeries {
	private List<Quote> stockQuotes = new ArrayList<Quote>();

	public TimeSeries() {

	}

	public void addQuote(Quote quote) {
		stockQuotes.add(quote);
	}

	public void removeQuote(int pos) {
		stockQuotes.remove(pos);
	}

	// ============ Methods: Object/Getters/Setters ============

	public List<Quote> getStockQuotes() {
		return stockQuotes;
	}
}
