package com.atguigu.RDD

import org.apache.spark.Partitioner

class MyPartitoner(numPartiton:Int) extends Partitioner{
  override def numPartitions: Int = numPartiton

  override def getPartition(key: Any): Int = ???
}
