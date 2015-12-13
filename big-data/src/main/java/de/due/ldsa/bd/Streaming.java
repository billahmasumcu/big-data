package de.due.ldsa.bd;

import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import de.due.ldsa.bd.analysis.Top;

/**
 * Running a streaming program continuously for online analysis. 
 * 
 * Check CustomReceiver in every x interval for streaming data. Then apply some analysis on it 
 * and export results into database.
 */
public class Streaming extends Base {

    private JavaStreamingContext streamingContext;

	public JavaReceiverInputDStream<String> baseDStream;

    public Streaming() {
        super();

        streamingContext = new JavaStreamingContext(sparkContext, Durations.seconds(Config.interval));
        
        baseDStream = streamingContext.receiverStream(new CustomReceiver());
    }

    public void run() {
    	Top.wordCounts(baseDStream);
    	
        streamingContext.start();
        streamingContext.awaitTermination();
    }

}
