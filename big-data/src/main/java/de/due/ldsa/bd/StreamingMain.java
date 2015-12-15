package de.due.ldsa.bd;

public class StreamingMain {
	public static void main(String[] args) {
		DataSource source = new DataProvider();
		source.setSourceData("Hello World");

		Streaming app = new Streaming();
		app.run();
	}
}
