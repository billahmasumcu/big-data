package de.due.ldsa.bd;

import org.apache.spark.storage.StorageLevel;
import org.apache.spark.streaming.receiver.Receiver;

/**
 * CustomReceiver class that collect data for Streaming.
 * This class is calling by JavaStreamingContext.receiverStream() method.
 */
public class CustomReceiver extends Receiver<String> {

	private static final long serialVersionUID = -1187714361055563697L;

	public CustomReceiver() {
		super(StorageLevel.MEMORY_AND_DISK_2());
	}

	public void onStart() {
		new Thread()  {
			@Override public void run() {
				receive();
			}
		}.start();
	}

	public void onStop() {}

	/**
	 * Get data from DataSource
	 */
	private void receive() {
		store(DataSource.getSourceData());
	}
}