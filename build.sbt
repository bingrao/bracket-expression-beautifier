organization := "com.github.mlangc"
name := "bracket-expression-beautifier"
version := "1.1.0-SNAPSHOT"

scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.11.8", "2.12.1")
scalacOptions := Seq("-encoding", "utf8", "-feature", "-deprecation", "-optimise", "-Ywarn-unused", "-Ywarn-dead-code", "-Ywarn-unused-import")

EclipseKeys.withSource := true
EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.8.2" % "test"
libraryDependencies += "org.scala-lang"  % "scala-compiler"    % scalaVersion.value % "test"

libraryDependencies += "com.lihaoyi" % "ammonite" % "0.8.1" % "test" cross CrossVersion.full
initialCommands in (Test, console) := """ammonite.Main().run()"""

//testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true
publishArtifact in Test := false

pomExtra := (
  <url>https://github.com/mlangc/bracket-expression-beautifier</url>
  <licenses>
    <license>
      <name>BSD-3-Clause</name>
      <url>http://opensource.org/licenses/BSD-3-Clause</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>scm:git:https://github.com/mlangc/bracket-expression-beautifier</url>
    <connection>scm:git:https://github.com/mlangc/bracket-expression-beautifier.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mlangc</id>
        <name>Matthias Langer</name>
      <url>http://mlangc.wordpress.com/</url>
    </developer>
  </developers>
)
