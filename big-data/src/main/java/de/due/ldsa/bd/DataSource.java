package de.due.ldsa.bd;

import java.util.List;

/**
 * Data source for Streaming class.
 * 
 * Link-Data group should call DataSource.setSourceData(data) for providing data to Streaming.
 * Right now, we only accept data as sting.
 * 
 * getSourceData has been called by CustomReceiver class.
 */
public class DataSource implements DataProvider {
	private static String stringSource;
	
	private static List<String> listSource;
	
	/**
	 * Set data into static property.
	 * 
	 * @param data
	 */
	public void setSourceData(String data) {
		stringSource = data;
	}
	
	public void setSourceData(List<String> data) {
		listSource = data;
	}
	
	/**
	 * Get data from static property.
	 * 
	 * @return String
	 */
	public String getSourceData() {
		return stringSource;
	}
	
	public List<String> getListSourceData() {
		return listSource;
	}
}
