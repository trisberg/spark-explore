package com.springdeveloper.spark;

import org.apache.spark.deploy.SparkSubmit;

/**
 * Run the Spark Hashtag Example
 */
public class RunScalaHashtags {

	public static void main(String[] args) {
		System.out.println("Running Scala Hashags!");

		String mainClass = "Hashtags";
		String jar = "lib/scala-hashtags-for-spark_2.10-0.1.0.jar";
		String master = "local[2]";
		String fileName = "file:/Users/trisberg/Test/data/hadoop-tweets_2014-08-29.txt";

		SparkSubmit.main(new String[] {"--class", mainClass, "--master", master, jar, fileName});

		System.out.println("Done!");
	}
}
