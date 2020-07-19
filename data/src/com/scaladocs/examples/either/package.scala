package com.scaladocs.examples

import cats._
import cats.implicits._

package object either {
  def getPage: Page = new Page {
    val title = "Either"

    def signature= FQSignature("scala.util.Either[+A, +B]")

    def description: Option[String] = """
    | Represents one of two possible values. Sometimes referred to as a
    | disjoint union. An instance of Either will be one of: `scala.util.Left`
    | or `scala.util.Right`.
    """.stripMargin.trim.some

    def tags: List[Tag] = List(
      Tag("Standard Library")
    )

    def links: List[Link] = List(
      Link("Docs", "https://www.scala-lang.org/api/2.13.1/scala/util/Either.html")
    )

    def examples: CodeExamples = List(
      CodeExample(
        description = Some("Basic Usage: Representing Success or Failure"), 
        tags = List(Tag("Abc", "http://".some)),
        snippet = Code("""
          |import scala.util.{Either, Right, Left}
          |
          |object DiceGame {
          |  private winRate = 0.5
          |  private prizeAmount = 100
          |  private rng = new Random()
          |
          |  def roll: Either[String, Long] = {
          |    if (rng.nextFloat() < winRate) {
          |      Right(100) // Winner 
          |    } else {
          |      Left("Sorry. Better Luck Next Time") // Loser
          |    }
          |  }
          |}
          """.stripMargin.trim
        )
      )
    )
  }
}
