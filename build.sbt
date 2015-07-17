name := "testPlay"

version := "1.0"

lazy val `testplay` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(jdbc,
                            anorm,
                            cache,
                            ws,
                            "mysql" % "mysql-connector-java" % "5.1.12",
                            "com.typesafe.slick" %% "slick" % "2.1.0",
                            "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
                            "org.mindrot" % "jbcrypt" % "0.3m",
                            "org.json4s" %% "json4s-jackson" % "3.2.11",
                            "com.typesafe.play" %% "play-slick" % "0.8.0")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  