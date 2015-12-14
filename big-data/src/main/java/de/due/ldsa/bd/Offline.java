package de.due.ldsa.bd;

import org.apache.spark.api.java.JavaRDD;
import de.due.ldsa.bd.analysis.Top;

public class Offline extends Base {
	private JavaRDD<String> baseRDD;
	
	public Offline() {
		super();
		
		populateBaseRDD();
	}
	
	private void populateBaseRDD() {
		DataSource source = new DataSource();
		baseRDD = sparkContext.parallelize(source.getListSourceData());
	}
	
	public void run() {
		Top.topWords(baseRDD, 10);
	}
}
