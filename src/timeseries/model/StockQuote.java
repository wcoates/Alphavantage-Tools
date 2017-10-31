package timeseries.model;

public class StockQuote {
  
  private String timestamp;
  private String open;
  private String high;
  private String low;
  private String close;
  private String volume;
  
  public StockQuote() {
    
  }

  // ============ Methods: Object/Getters/Setters ============
  
  public final String getTimestamp() {
    return timestamp;
  }

  public final void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public final String getOpen() {
    return open;
  }

  public final void setOpen(String open) {
    this.open = open;
  }

  public final String getHigh() {
    return high;
  }

  public final void setHigh(String high) {
    this.high = high;
  }

  public final String getLow() {
    return low;
  }

  public final void setLow(String low) {
    this.low = low;
  }

  public final String getClose() {
    return close;
  }

  public final void setClose(String close) {
    this.close = close;
  }

  public final String getVolume() {
    return volume;
  }

  public final void setVolume(String volume) {
    this.volume = volume;
  }
  
  @Override
  public String toString() {
    return "[Timestamp:\"" + timestamp + "\", Open:\"" + open + "\", High:\"" + high + "\", Low:\"" + low + "\", Close:\"" + close
        + "\", Volume:\"" + volume + "\"]";
  }

}
