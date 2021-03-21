package com.thaj.zconfig.demo

import com.thaj.zconfig.demo.ApplicationConfig.DataSource
import zio.config._
import ConfigDescriptor._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.W
import eu.timepit.refined.numeric.GreaterEqual
import zio.config.magnolia.{ describe, descriptor, name, DeriveConfigDescriptor }
import zio.config.refined._

final case class ApplicationConfig(source: DataSource, region: Option[String])

object ApplicationConfig {
  import zio.config._

  val config: ConfigDescriptor[ApplicationConfig] =
    descriptor[ApplicationConfig] ?? "Config related to ETL frameworks"

  sealed trait DataSource

  final case class Database(
    @describe("HOST name if source is database") host: Refined[String, NonEmpty],
    @describe("Port if source is a database") port: Refined[Int, GreaterEqual[W.`1024`.T]],
    @name("username") userName: Refined[String, NonEmpty],
    password: Refined[String, NonEmpty]
  ) extends DataSource

  final case class S3Bucket(bucketName: String, prefix: String) extends DataSource

  final case class Kafka(topicName: String, @describe("Topics that") brokers: List[String]) extends DataSource
}
