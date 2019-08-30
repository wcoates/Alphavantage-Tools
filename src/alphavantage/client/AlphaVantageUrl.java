package alphavantage.client;

public class AlphaVantageUrl {
	StringBuilder sb = new StringBuilder();

	private static final String baseUri = "https://www.alphavantage.co/";
	private static final String queryName = "query?";
	private static final String functionName = "&function=";
	private static final String symbolName = "&symbol=";
	private static final String intervalName = "&interval=";
	private static final String keyName = "&apikey=";
	private static final String datatypeName = "&datatype=";

	private String functionValue;
	private String symbolValue;
	private String keyValue;
	private String datatypeValue;
	private String intervalValue;

	public static String url;

	private AlphaVantageUrl(Builder builder) {
		functionValue = builder.functionValue;
		symbolValue = builder.symbolValue;
		keyValue = builder.keyValue;
		intervalValue = builder.intervalValue;
		datatypeValue = builder.datatypeValue;

		sb.append(baseUri).append(queryName).append(functionName).append(functionValue).append(symbolName)
				.append(symbolValue).append(keyName).append(keyValue);

		// Optional Params
		if (intervalValue != null) {
			sb.append(intervalName).append(intervalValue);
		}

		if (datatypeValue != null) {
			sb.append(datatypeName).append(datatypeValue);
		}

		url = sb.toString();
	}

	// Getters/Setters/Object Methods

	public static final String getUrl() {
		return url;
	}

	public final String getFunctionValue() {
		return functionValue;
	}

	public final void setFunctionValue(String functionValue) {
		this.functionValue = functionValue;
	}

	public final String getSymbolValue() {
		return symbolValue;
	}

	public final void setSymbolValue(String symbolValue) {
		this.symbolValue = symbolValue;
	}

	public final String getIntervalValue() {
		return intervalValue;
	}

	public final void setIntervalValue(String intervalValue) {
		this.intervalValue = intervalValue;
	}

	public final String getDatatypeValue() {
		return datatypeValue;
	}

	public final void setDatatypeValue(String datatypeValue) {
		this.datatypeValue = datatypeValue;
	}

	@Override
	public final String toString() {
		return url;
	}

	public static class Builder {
		private String functionValue;
		private String symbolValue;
		private String intervalValue;
		private String keyValue;
		private String datatypeValue;

		public Builder() {

		}

		public Builder functionValue(String functionValue) {
			this.functionValue = functionValue;
			return this;
		}

		public Builder symbolValue(String symbolValue) {
			this.symbolValue = symbolValue;
			return this;
		}

		public Builder intervalValue(String intervalValue) {
			this.intervalValue = intervalValue;
			return this;
		}

		public Builder keyValue(String keyValue) {
			this.keyValue = keyValue;
			return this;
		}

		public Builder datatypeValue(String datatypeValue) {
			this.datatypeValue = datatypeValue;
			return this;
		}

		public AlphaVantageUrl build() {
			return new AlphaVantageUrl(this);
		}
	}
}
