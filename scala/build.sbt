ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "me.rafaavila"
ThisBuild / organizationName := "ravila"

lazy val root = (project in file("."))
  .settings(
    name := "leet-code"
  )

libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test

testFrameworks += new TestFramework("munit.Framework")
