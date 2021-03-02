package com.thaj.zconfig.demo

import zio.config._
import ConfigDescriptor._
import zio.config.typesafe.TypesafeConfigSource

object Main {
  def main(args: Array[String]): Unit = {
    val jsonSource =
      s"""
         |{
         |   "dataSource" : {
         |     "DataSource" : {
         |       "Database" : {
         |         "host"    : "host",
         |         "port"    : "123",
         |         "username": "un",
         |         "password": "pw",
         |       }
         |    }
         |   }
         |
         |   "region" : "ap-southeast-2"
         |
         |}
         |""".stripMargin

    val sourceEither: Either[ReadError[String], ConfigSource] =
      TypesafeConfigSource.fromHoconString(jsonSource)

    val configResult: Either[ReadError[String], Unit] =
      for {
        source <- sourceEither
        applicationConfig <- read(ApplicationConfig.config from source)
      } yield Core.run(applicationConfig)

    println(configResult)
  }
}

object Core {
  def run(applicationConfig: ApplicationConfig): Unit = {
    applicationConfig.dataSource match {
      case database @ ApplicationConfig.DataSource.Database(_, _, _, _) => println(s"Database, ${database}")
      case ApplicationConfig.DataSource.S3Bucket(bucketName, prefix) => println(s"s3 bucket, ${bucketName}, ${prefix}")
      case ApplicationConfig.DataSource.Kafka(brokers, topicName) => println(s"kafka. ${brokers}, ${topicName}")
    }
  }
}

