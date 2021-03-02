package com.thaj.zconfig.demo

import com.thaj.zconfig.demo.ApplicationConfig._
import zio.config.magnolia.DeriveConfigDescriptor.Descriptor
import Descriptor.SealedTraitStrategy
import SealedTraitStrategy._
import zio.config.magnolia.DeriveConfigDescriptor

final case class ApplicationConfig(dataSource: DataSource)
object ApplicationConfig {

  val config = customDerivation.descriptor[ApplicationConfig]

  sealed trait DataSource

  object DataSource {

    final case class Database(host: String, port: Int, username: String, password: String)
      extends DataSource

    final case class S3Bucket(bucketName: String, prefix: String)
      extends DataSource

    final case class Kafka(brokers: List[String], topicName: String)
      extends DataSource

  }
}
