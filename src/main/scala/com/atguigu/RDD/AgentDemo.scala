package com.atguigu.RDD

import org.apache.spark.{SparkConf, SparkContext}

object AgentDemo {



  def main(args: Array[String]): Unit = {

    // 1516609143867 6 7 64 16
    //时间戳，省份，城市，用户，广告
    //2. 需求：统计出每一个省份广告被点击次数的TOP3
    val conf: SparkConf = new SparkConf().setAppName("AgentDemo").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val textRDD = sc.textFile("G:\\Java视频\\尚硅谷spark生态体系\\spark\\day01\\安装包资料\\数据\\agent.log")
    //((省份，广告),1)
    val rdd2 = textRDD.map(_.split(" ")).map(x=>((x(1),x(4)),1))
    //((省份，广告),13)
    val rdd3 = rdd2.reduceByKey(_+_)

    //(省份，(广告,13))
    val rdd4 = rdd3.map(x => (x._1._1,(x._1._2,x._2)))
//按照省份分组
    val rdd5 = rdd4.groupByKey()

    val rdd6 = rdd5.mapValues(x => x.toList.sortBy(_._2).take(3))


    rdd6.foreach(println)

    sc.stop()

  }
}
