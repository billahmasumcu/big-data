package de.due.ldsa.bd;

public class StreamingMain {
    public static void main(String[] args) {
    	DataSource source = new DataSource();
    	source.setSourceData("Hello World");
    	
    	Streaming app = new Streaming();
    	app.run();  	
    }
}
