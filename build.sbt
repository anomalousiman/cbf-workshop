name := "depop-scala-workshop"

version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    PlayKeys.playDefaultPort := 9009,
    scalafmtOnCompile := true,
    scalafmtTestOnCompile := true,
    scalafmtVersion := "1.4.0",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatest" %% "scalatest" % "3.2.0" % "test"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
