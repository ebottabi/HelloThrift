name := "HelloThrift"

version := "1.0"

scalaVersion := "2.11.7"

enablePlugins(JavaServerAppPackaging)

com.twitter.scrooge.ScroogeSBT.newSettings

scalariformSettings

resolvers ++= Seq(
  "twttr" at "http://maven.twttr.com/"
)

val finagleVersion = "6.27.0"

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-core" % finagleVersion,
  "com.twitter" %% "finagle-thrift" % finagleVersion,
  "com.twitter" %% "finagle-thriftmux" % finagleVersion,
  "com.twitter" % "finagle-serversets_2.11" % "6.27.0",
  "com.twitter" % "finagle-http_2.11" % "6.27.0",
  "com.twitter" % "twitter-server_2.11" % "1.12.0",
  "com.twitter" %% "scrooge-core" % "3.20.0",
  "org.apache.thrift" % "libthrift" % "0.8.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "com.googlecode.json-simple" % "json-simple" % "1.1.1",
  "com.typesafe.play" % "play-json_2.11" % "2.3.9",
  "org.slf4j" % "slf4j-log4j12" % "1.7.16"
)


scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-language:_",
  "-unchecked",
  "-Xlint:_",
  "-Xfuture",
  "-Ywarn-dead-code",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard"
)
