package com.thaj.zconfig.demo

import zio.config._, ConfigDescriptor._
import zio.config.typesafe.TypesafeConfigSource

object Main {
  def main(args: Array[String]): Unit = {
    val json: String =
      s"""
         |
         |  {
         |   "source" : {
         |     "Database" : {
         |       "port" : "1024",
         |       "host" : "sdsdsd"
         |       "username" :  "un",
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
        config = ApplicationConfig.config from source
        applicationConfig <- read(config)
        _ = println(generateDocs(config).toTable.toGithubFlavouredMarkdown)
      } yield Core.run(applicationConfig)

    println(sourceEither)
  }
}

object Core {
  def run(applicationConfig: ApplicationConfig): Unit =
    applicationConfig.source match {
      case c @ ApplicationConfig.Database(host, port, userName, password) => println(c.host.value)
      case c @ ApplicationConfig.S3Bucket(bucketName, prefix) => println(c)
      case c @ ApplicationConfig.Kafka(topicName, brokers) => println(c)
    }
}
