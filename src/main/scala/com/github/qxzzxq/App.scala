package com.github.qxzzxq

import com.github.qxzzxq.entity.TestObject
import com.github.qxzzxq.factory.MyFactory
import com.jcdecaux.setl.Setl

/**
 * Hello world!
 *
 */
object App {

  def main(args: Array[String]): Unit = {

    val setl = Setl.builder()
      .withDefaultConfigLoader()
      .getOrCreate()

    setl
      .setSparkRepository[TestObject]("testObjectRepository")

    setl
      .newPipeline()
      .addStage[MyFactory]()
      .describe()
      .run()
  }
}