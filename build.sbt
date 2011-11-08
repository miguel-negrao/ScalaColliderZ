name := "ScalaColliderZ"

version := "0.1"

organization := "org.friendlyvirus.mn"

scalaVersion := "2.9.1"

// crossScalaVersions := Seq("2.9.1", "2.9.0", "2.8.1")

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "6.0.4-SNAPSHOT",  
  "de.sciss" %% "scalacollider" % "0.30"
)
