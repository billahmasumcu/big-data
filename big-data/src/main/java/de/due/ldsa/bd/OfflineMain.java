package de.due.ldsa.bd;

import java.util.Arrays;
import java.util.List;

public class OfflineMain {
	public static void main(String[] args) {
		// Building an example List.
		List<String> items = Arrays.asList("Hello World1", "Hello World2", "Hello World3");
    	
    	DataProvider source = new DataProvider();
    	source.setSourceData(items);
    	
    	Offline app = new Offline();
    	app.run();  	
	}
}
