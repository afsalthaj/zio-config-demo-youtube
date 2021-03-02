package com.thaj.zconfig.demo

import com.thaj.zconfig.demo.ApplicationConfig.DataSource
import zio.config._
import ConfigDescriptor._
import zio.config.magnolia.descriptor

final case class ApplicationConfig(source: DataSource, region: Option[String])

object ApplicationConfig {

  val config: ConfigDescriptor[ApplicationConfig] =
    descriptor[ApplicationConfig].mapKey(_.toUpperCase)


  sealed trait DataSource

  final case class Database(host: String, port: Int, userName: String, password: String) extends DataSource

  final case class S3Bucket(bucketName: String, prefix: String) extends DataSource

  final case class Kafka(topicName: String, brokers: List[String]) extends DataSource

}
