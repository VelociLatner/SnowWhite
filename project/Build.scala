import sbt._
import Keys._

object ApplicationBuild extends Build {

  val appName = "Snow White -- PICS Security Service"
  val appVersion = "0.1"

  lazy val root = Project(id = "root", base = file("."))

  val appDependencies = Seq(
    "com.typesafe.slick" % "slick_2.10" % "1.0.1",
    "mysql" % "mysql-connector-java" % "5.1.27",
    "org.scalatest" % "scalatest_2.10" % "2.0" % "it,test",
    "org.mockito" % "mockito-all" % "1.9.5" % "it,test"
  )

}
