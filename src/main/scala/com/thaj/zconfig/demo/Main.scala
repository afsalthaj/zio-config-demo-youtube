package com.thaj.zconfig.demo

// @afsal2

import zio.config._
import ConfigDescriptor._
import zio.config.typesafe.TypesafeConfigSource
import zio.config.gen._

object Main {
  def main(args: Array[String]): Unit = {
    val json: String =
      s"""
         |
         |  {
         |   SOURCE : {
         |     "S3BUCKET" : {
         |       "BUCKETNAME" : "bucket"
         |       "PREFIX" : "12"
         |    }
         |  }
         |
         |  REGION: AUSTRALIA
         |}
         |""".stripMargin

    val source: Either[ReadError[String], ConfigSource] =
      TypesafeConfigSource.fromHoconString(json)

    val result: Either[ReadError[String], Unit] =
      for {
        jsonSource <- source
        desc = ApplicationConfig.config from (jsonSource <> ConfigSource.fromMap(Map()))
        markdown = generateDocs(desc).toTable.toGithubFlavouredMarkdown
        _ = println(markdown)
        _ = println(gen.generateConfigJson(desc, size = 10).unsafeRunChunk)
        result <- read(desc)
        result2 = println(write(desc, result).map(_.flattenString()))
      } yield Core.run(result)

    println(result.swap.map(_.prettyPrint()))

  }
}

object Core {
  def run(applicationConfig: ApplicationConfig): Unit =
    applicationConfig.source match {
      case c @ ApplicationConfig.Database(host, port, userName, password) => println(c)
      case c @ ApplicationConfig.S3Bucket(bucketName, prefix) => println(c)
      case c @ ApplicationConfig.Kafka(topicName, brokers) => println(c)
    }
}
