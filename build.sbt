name := "zio-config-demo"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio-config" % "1.0.0",
  "dev.zio" %% "zio-config-magnolia" % "1.0.0",
  "dev.zio" %% "zio-config-typesafe" % "1.0.0",
  "dev.zio" %% "zio-config-refined" % "1.0.0",
  "dev.zio" %% "zio-config-gen" % "1.0.0",

)
