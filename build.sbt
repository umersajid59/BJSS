ThisBuild / scalaVersion := "2.12.3"
ThisBuild / organization := "com.bjss.priceBasket"


lazy val hello = (project in file("."))
  .settings(
    name := "PriceBasket",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % Test
  )
