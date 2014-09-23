package com.springdeveloper.spark;

import org.apache.spark.deploy.SparkSubmit;

/**
 * Run the Spark Hashtag Example
 */
public class RunSparkHashtags {

	public static void main(String[] args) {
		System.out.println("Running Spark Hashags!");

		String app = "com.springdeveloper.spark.SparkHashtags";
		String jar = "lib/spark-hashtags-0.1.0.jar";
		String master = "yarn-cluster";
		String fileName = "hdfs://borneo:8020/tweets/input/data/hadoop-tweets_2014-08-11.txt";

		SparkSubmit.main(new String[] {"--class", app, "--master", master, jar, fileName});

		System.out.println("Done!");
	}
}
