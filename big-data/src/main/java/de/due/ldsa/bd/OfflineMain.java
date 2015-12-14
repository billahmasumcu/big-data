package de.due.ldsa.bd;

import java.util.Arrays;
import java.util.List;

public class OfflineMain {
	public static void main(String[] args) {
		// Building an example List.
    	String example = "Hello World";
    	List<String> items = Arrays.asList(example.split("[\\r\\n]+"));
    	
    	DataSource source = new DataSource();
    	source.setSourceData(items);
    	
    	Offline app = new Offline();
    	app.run();  	
	}
}
