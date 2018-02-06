
package timeseries;

import timeseries.model.TimeSeries;

public interface TimeSeriesClient {

	public enum TimeSeriesTypes {
		INTRADAY("TIME_SERIES_INTRADAY"), DAILY("TIME_SERIES_DAILY"), DAILY_ADJUSTED(
				"TIME_SERIES_DAILY_ADJUSTED"), WEEKLY("TIME_SERIES_WEEKLY"), MONTHLY("TIME_SERIES_MONTHLY");

		private final String interval;

		private TimeSeriesTypes(final String value) {
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

	public TimeSeries getTimeSeriesData(TimeSeriesTypes seriesType, String stockTicker) throws Exception;
}
