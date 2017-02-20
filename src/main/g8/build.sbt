lazy val versions = new {
  val scalaTest = "3.0.0"
  val scalaTestPlay = "$scalaTestPlayVersion$"
  val scalaGuice = "$scalaGuiceVersion$"
  val ficus = "1.4.0"
}

lazy val commonBuildSettings = Seq(
  organization := "$organization$",
  name := "$name$",
  version := "$projectVersion$",
  scalaVersion in ThisBuild := "$scalaVersion$",
  scalacOptions ++= Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-Ywarn-value-discard", // Warn wen value was discard
    "-Ywarn-dead-code", // Warn when dead code is identified.
    "-Ywarn-nullary-unit",
    "-Ywarn-numeric-widen", // Warn when numerics are widened.
    "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
    "-Ywarn-adapted-args",
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.
    "-Xfatal-warnings", // Fail the compilation if there are any warnings.
    "-Yno-adapted-args", // Warn if an argument list is modified to match the receiver.
    "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
    "-Xlint:-stars-align,_", // Enable recommended additional warnings.
    "-Xlint:missing-interpolator", // A string literal appears to be missing an interpolator id.
    "-explaintypes", //Explain type errors in more detail.
    "-encoding",
    "UTF-8",
    "-Xexperimental",
    "-Xfuture" // Turn on future language features and guard against a few deprecated features around Futures.
  ),
  resolvers ++= Seq(
    Resolver.defaultLocal,
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)
lazy val root = (project in file("."))
  .settings(commonBuildSettings)
  .settings(libraryDependencies ++= Seq(
    ws,
    //Guice Helper
    "net.codingwell" %% "scala-guice" % versions.scalaGuice,

    "com.iheart" %% "ficus" % versions.ficus,
    //Test
    "org.scalatestplus.play" %% "scalatestplus-play" % versions.scalaTestPlay % "test"
  ))
  .enablePlugins(PlayScala)
