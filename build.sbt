lazy val root = (project in file(".")).
  settings(
    name := "scala-test",
    version := "1.0",
    scalaVersion := "2.11.4",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"
  )

