package com.atguigu.RDD

import org.apache.spark.{RangePartitioner, SparkConf, SparkContext}

object RDDdemo {



  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("RDDdemo").setMaster("local[*]")
    val sc = new SparkContext(conf)

    sc.makeRDD(List((1,List("","")),(1,List("",""))))



//
//    val rdd2 = sc.parallelize(Array((1,2),(3,4),(5,6),(7,8)))
//    val collect = rdd2.partitionBy(new RangePartitioner(2,rdd2))
//    val rdd3 = collect.mapPartitionsWithIndex((x,it) =>Iterator(x+":[" + it.mkString(",") + "]")).collect
//    println(rdd3.toList)

  }

}
