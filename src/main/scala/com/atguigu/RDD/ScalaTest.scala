package com.atguigu.RDD

object ScalaTest {
  def main(args: Array[String]): Unit = {

    val arr = Array(1,2,3,5,6,7,8)
    val it = arr.iterator
    println(it.filter(_ > 3).toList)


    val it2 = Iterable("hahaha")
    println(it2.toList)


//    arr.map(_)

  }
}
