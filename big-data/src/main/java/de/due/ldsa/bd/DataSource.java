package de.due.ldsa.bd;

/**
 * Data source for Streaming class.
 * 
 * Link-Data group should call DataSource.setSourceData(data) for providing data to Streaming.
 * Right now, we only accept data as sting.
 * 
 * getSourceData has been called by CustomReceiver class.
 */
public class DataSource {
	private static String sourceData;
	
	/**
	 * Set data into static property.
	 * 
	 * @param data
	 */
	public static void setSourceData(String data) {
		sourceData = data;
	}
	
	/**
	 * Get data from static property.
	 * 
	 * @return String
	 */
	public static String getSourceData() {
		return sourceData;
	}
}
