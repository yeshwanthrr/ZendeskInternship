name := "ZendeskIntern"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies ++=  Seq(
  "org.scalaj" %% "scalaj-http" % "2.4.2",
  "com.typesafe.play" %% "play-json" % "2.7.3",
  "org.apache.commons" % "commons-lang3" % "3.9",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  //"org.scala-lang.modules" %% "scala-swing" % "3.0.0"
)