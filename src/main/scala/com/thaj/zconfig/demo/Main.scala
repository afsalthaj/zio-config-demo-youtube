package com.thaj.zconfig.demo

import zio.config._, ConfigDescriptor._
import zio.config.typesafe.TypesafeConfigSource
import zio.config.gen._

object Main {
  def main(args: Array[String]): Unit = {
    val json: String =
      s"""
         |
         |  {
         |   "source" : {
         |     "Database" : {
         |       "host" : "host"
         |       "port" : "12",
         |       "userName" :  "un",
         |       "password" : "pw"
         |     }
         |  }
         |
         |  "region": "australia"
         |}
         |""".stripMargin

    val source: Either[ReadError[String], ConfigSource] =
      TypesafeConfigSource.fromHoconString(json)

    val sourceEither: Either[ReadError[String], Unit] =
      for {
        source <- source
        applicationConfig <- read(ApplicationConfig.config from source)
        result = gen.generateConfigJson(ApplicationConfig.config, 10).unsafeRunChunk
        _ = println(result)
      } yield Core.run(applicationConfig)

    println(sourceEither)
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
