package alphavantange.client.model;

import java.util.ArrayList;
import java.util.List;

public class QuoteList {
	private List<Quote> stockQuotes = new ArrayList<Quote>();

	public QuoteList() {

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

	@Override
	public String toString() {
		return "QuoteList [stockQuotes=" + stockQuotes + "]";
	}
}
