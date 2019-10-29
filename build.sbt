
lazy val generator = (project in file("modules/generator"))
  .enablePlugins(ScalaxbPlugin)
  .settings(
    Seq(
      version := "1.0",
      scalaVersion := "2.12.8",
      crossScalaVersions := Seq("2.12.8"),
      scalacOptions ++= Seq(
        "-encoding",
        "UTF-8",
        "-target:jvm-1.8"
      ),
      libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.1.1",
      libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.1",
      libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8" % "test",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test",
      scalaxbGenerateDispatchClient in (Compile, scalaxb) := false,
      scalaxbGenerateGigahorseClient in (Compile, scalaxb) := false,
      scalaxbNamedAttributes in (Compile, scalaxb) := true,
      scalaxbPackageName in (Compile, scalaxb) := "com.test.generated",
      scalaxbGenerateRuntime in (Compile, scalaxb) := true,
      mappings in (Compile, packageSrc) ++= { // publish generated sources
        import Path._
        val srcs = (managedSources in Compile).value
        val sdirs = (managedSourceDirectories in Compile).value
        val base = baseDirectory.value
        (((srcs --- sdirs --- base) pair (relativeTo(sdirs) | relativeTo(base) | flat)) toSeq)
      }
    )
  )