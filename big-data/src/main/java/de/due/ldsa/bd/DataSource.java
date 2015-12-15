package de.due.ldsa.bd;

import java.util.List;

/**
 * Interface for data provider
 */
public interface DataSource {
	public void setSourceData(String data);
	
	public void setSourceData(List<?> data);
	
	public String getStringSourceData();
	
	public List<?> getListSourceData();
}
