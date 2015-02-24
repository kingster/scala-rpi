import com.typesafe.sbt.SbtStartScript
import spray.revolver.RevolverPlugin.Revolver

organization  := "in.kinshuk"

version       := "0.1"

name          := "scala-rpi"

scalaVersion  := "2.10.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= Seq(
  "org.specs2"          %%  "specs2"        % "1.14" % "test"
)

parallelExecution in Test := false

assembleArtifact in assemblyPackageScala := true


assemblyJarName in assembly := "scala-rpi.jar"

mainClass in assembly := Some("in.kinshuk.rpi.batasia.Boot") // fully qualified path

test in assembly := {}

seq(Revolver.settings: _*)

seq(SbtStartScript.startScriptForJarSettings: _*)
