package timeseries.model;

import java.util.ArrayList;
import java.util.List;

public class TimeSeries {
    
  private List <StockQuote> stockQuotes = new ArrayList<StockQuote>();
  
  public TimeSeries() {
    
  }
  
  public void addQuote(StockQuote quote) {
    stockQuotes.add(quote);
  }
  
  public void removeQuote(int pos) {
    stockQuotes.remove(pos);
  }
  
  // ============ Methods: Object/Getters/Setters ============
  
  public List<StockQuote> getStockQuotes() {
    return stockQuotes;
  }
  
  @Override
  public String toString() {
    return "Quotes Count: " + stockQuotes.size();
  }
}
