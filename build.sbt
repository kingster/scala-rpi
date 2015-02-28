import com.typesafe.sbt.SbtStartScript
import spray.revolver.RevolverPlugin.Revolver

organization := "in.kinshuk"

version := "0.1"

name := "scala-rpi"

scalaVersion := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "Maven2 Local" at Resolver.mavenLocal.root,
  "Spray Repo" at "http://repo.spray.io/",
  "Sonatype OSS Maven Repository" at "https://oss.sonatype.org/content/groups/public"
)

libraryDependencies ++= Seq(
  "com.pi4j" % "pi4j-core" % "1.0-SNAPSHOT",
  "io.spray" % "spray-can" % "1.2-M8",
  "io.spray" % "spray-routing" % "1.2-M8",
  "io.spray" % "spray-testkit" % "1.2-M8" % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.2.0-RC1",
  "com.typesafe.akka" %% "akka-testkit" % "2.2.0-RC1" % "test",
  "org.specs2" %% "specs2" % "1.14" % "test"
)

parallelExecution in Test := false

assembleArtifact in assemblyPackageScala := true


assemblyJarName in assembly := "scala-rpi.jar"

mainClass in assembly := Some("in.kinshuk.rpi.batasia.Boot") // fully qualified path

test in assembly := {}

seq(Revolver.settings: _*)

seq(SbtStartScript.startScriptForJarSettings: _*)
