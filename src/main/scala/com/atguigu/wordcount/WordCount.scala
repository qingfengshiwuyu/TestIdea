package com.atguigu.wordcount

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("hdfs://hadoop102:9000/word.txt")
      .flatMap(_.split(" "))
      .map((_,1)).reduceByKey(_+_)

//
    //  rdd.saveAsTextFile("hdfs://hadoop102:9000/wordcount")
    val rdd1 = rdd.collect()
    println(rdd1.toList)
    sc.stop()


  }
}
