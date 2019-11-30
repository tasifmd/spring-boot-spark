package com.tasif.apachespark.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class SparkConfig {

	@Value("${spark.app.name:spartans}")
	private String appName;

	@Value("${spark.home}")
	private String sparkHome;

	@Value("${spark.master.uri:local}")
	private String masterUri;

	@Bean
	public SparkConf sparkConf() {
		SparkConf sparkConf = new SparkConf().setAppName(appName).setMaster(masterUri);
		return sparkConf;
	}

	@Bean
	public JavaSparkContext javaSparkContext() {
		return new JavaSparkContext(sparkConf());
	}

//    @Bean
//    public SparkSession sparkSession(){
//        return SparkSession
//                .builder()
//                .sparkContext(javaSparkContext().sc())
//                .appName("Java Spark SQL basic example")
//                .getOrCreate();
//    }

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
