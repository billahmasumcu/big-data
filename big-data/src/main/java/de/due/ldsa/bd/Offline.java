package de.due.ldsa.bd;

import org.apache.spark.api.java.JavaRDD;
import de.due.ldsa.bd.analysis.Top;

import javax.json.JsonObject;

public class Offline extends Base {
	private JavaRDD<?> baseRDD;
	
	public Offline() {
		super();
		
		populateBaseRDD();
	}
	
	private void populateBaseRDD() {
		DataProvider source = new DataProvider();
		baseRDD = sparkContext.parallelize(source.getListSourceData());
	}
	
	public void run() {
		Top.topWords((JavaRDD<String>) baseRDD, 10);
	}
}
