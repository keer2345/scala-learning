name := "ch01"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"


organization := "com.appliedscala.tutorials.sbt"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.4.4"
libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.10.5",
  "org.joda" % "joda-convert" % "2.2.1"
)
