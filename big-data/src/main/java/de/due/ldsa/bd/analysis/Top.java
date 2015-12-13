package de.due.ldsa.bd.analysis;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;

import java.util.List;
import java.util.Arrays;
import scala.Tuple2;

public class Top {

    public static void wordCounts(JavaDStream<String> baseStream) {
    	JavaDStream<String> words = baseStream.flatMap(s -> Arrays.asList(s.split(" ")));

    	JavaPairDStream<String, Integer> pairs = words.mapToPair(s -> new Tuple2(s, 1));

    	JavaPairDStream<String, Integer> wordCounts = pairs.reduceByKey((a, b) -> a + b);
    	
    	wordCounts.print();    	
    }

    public static List<String> topWords(JavaRDD<String> baseRDD, Integer number) {
        JavaRDD<String> words = baseRDD.flatMap(s -> Arrays.asList(s.split(" ")));

        JavaPairRDD<String, Integer> pairs = words.mapToPair(s -> new Tuple2(s, 1));

        JavaPairRDD<String, Integer> wordCounts = pairs.reduceByKey((a, b) -> a + b);

        List sorted = wordCounts.mapToPair(t -> new Tuple2(t._2, t._1))
            .sortByKey(false)
            .collect();

        if (sorted.size() < number ) {
            number = sorted.size();
        }

        return sorted.subList(0, number);
    }
}
