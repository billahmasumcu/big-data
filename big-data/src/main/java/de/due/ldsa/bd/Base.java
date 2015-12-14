package de.due.ldsa.bd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;

/**
 * Base class for creating spark context.
 * 
 * This abstract class has two direct childs: Streaming and Offline
 */
public abstract class Base {

    protected SparkConf conf;

    protected JavaSparkContext sparkContext;

    protected SQLContext sqlContext;

    public Base() {
        conf = new SparkConf().setMaster(Config.master).setAppName(Config.appName);
        sparkContext = new JavaSparkContext(conf);
        sqlContext = new SQLContext(sparkContext);
    }
}
