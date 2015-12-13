package de.due.ldsa.bd;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.api.java.JavaRDD;

import java.util.List;

/**
 * Base class for creating spark context.
 * 
 * This abstract class has two direct childs: Streaming and Offline
 */
public abstract class Base {

    protected SparkConf conf;

    protected JavaSparkContext sparkContext;

    protected SQLContext sqlContext;

    protected JavaRDD<String> baseRDD;

    public Base() {
        conf = new SparkConf().setMaster(Config.master).setAppName(Config.appName);
        sparkContext = new JavaSparkContext(conf);
        sqlContext = new SQLContext(sparkContext);
    }

    public void setDataSource(String path) {
        baseRDD = sparkContext.textFile(path);
    }

    public void setDataSource(List<String> list) {
        baseRDD = sparkContext.parallelize(list);
    }

}
