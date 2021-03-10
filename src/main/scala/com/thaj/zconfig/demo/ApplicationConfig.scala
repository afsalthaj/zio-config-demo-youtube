package com.thaj.zconfig.demo

import com.thaj.zconfig.demo.ApplicationConfig.DataSource
import zio.config._
import ConfigDescriptor._
import zio.config.magnolia.{DeriveConfigDescriptor, descriptor}

final case class ApplicationConfig(source: DataSource, region: Option[String])

object ApplicationConfig {
  import zio.config._

  val config: ConfigDescriptor[ApplicationConfig] =
    descriptor[ApplicationConfig]

  sealed trait DataSource

  final case class Database(host: String, port: Int, userName: String, password: String) extends DataSource

  final case class S3Bucket(bucketName: String, prefix: String) extends DataSource

  final case class Kafka(topicName: String, brokers: List[String]) extends DataSource
}
