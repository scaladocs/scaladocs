package com.scaladocs.examples

import cats._
import cats.implicits._

package object either {
  def getPage: Page = new Page {
    def canonicalPath = "scala/util/Either.html"

    def title = "Either"

    def metaDescription: String = """
    | Simple usage examples for Scala's Either type. How to construct an Either type.
    """.stripMargin.trim

    def signature = FQSignature("scala.util.Either[+A, +B]")

    def description: Option[String] = """
    | Represents one of two possible values. Sometimes referred to as a
    | disjoint union. An instance of Either will be one of: `scala.util.Left`
    | or `scala.util.Right`.
    """.stripMargin.trim.some

    def tags: List[Tag] = List(Tag("Standard Library"))

    def links: List[Link] = List(
      Link("Scala Docs for Either", "https://www.scala-lang.org/api/current/scala/util/Either.html"),
      Link("Source Code for Either", "https://github.com/scala/scala/blob/2.13.x/src/library/scala/util/Either.scala")
    )

    def children: Pages = List(LeftExamples.getPage, RightExamples.getPage)

    def examples: CodeExamples = List(
      CodeExample(
        title = "Basic Usage: Representing Success or Failure",
        description = none,
        tags = Nil,
        snippet = Code("""
          |import scala.util.{Either, Right, Left, Random}
          |
          |object DiceGame {
          |  private val winRate = 0.5
          |  private val prizeAmount = 100
          |  private val rng = new Random()
          |
          |  def roll: Either[String, Long] = {
          |    if (rng.nextFloat() <= winRate) {
          |      Right(100) // Winner 
          |    } else {
          |      Left("Sorry. Better Luck Next Time") // Loser
          |    }
          |  }
          |}
          |
          |(1 to 5).map(_ => DiceGame.roll).foreach(println)
          """.stripMargin.trim)
      )
    )
  }
}
