name := "spark_project"

version := "0.1"

scalaVersion := "2.13.6"

val akkaVersion="2.6.17"


libraryDependencies ++= Seq(
          "org.apache.spark" %% "spark-sql" % "3.2.0",
          "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
          "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test)

mainClass in assembly := Some("com.FirstTask.FirstTask")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}