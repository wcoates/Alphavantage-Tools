package alphavantage.client.functions;

public class Function {
	private String function;

	public Function(String function) {
		this.function = function;
	}

	public final String getFunction() {
		return function;
	}

	@Override
	public final String toString() {
		return function;
	}

	public enum TimeSeries {
		INTRADAY("TIME_SERIES_INTRADAY"), DAILY("TIME_SERIES_DAILY"), DAILY_ADJUSTED(
				"TIME_SERIES_DAILY_ADJUSTED"), WEEKLY("TIME_SERIES_WEEKLY"), MONTHLY("TIME_SERIES_MONTHLY");

		private final String interval;

		private TimeSeries(final String value) {
			this.interval = value;
		}

		public final String getValue() {
			return interval;
		}

		public final Boolean equalValue(String value) {
			return this.interval.equals(value);
		}

		@Override
		public final String toString() {
			return getValue();
		}
	}

	public enum Indicator {
		SMA("SMA"), EMA("EMA"), MACD("MACD"), STOCH("STOCH"), RSI("RSI"), ADX("ADX"), CCI("CCI"), AROON(
				"AROON"), BBANDS("BBANDS"), AD("AD"), OBV("OBV");

		private final String interval;

		private Indicator(final String value) {
			this.interval = value;
		}

		public final String getValue() {
			return interval;
		}

		@Override
		public final String toString() {
			return getValue();
		}
	}
}
