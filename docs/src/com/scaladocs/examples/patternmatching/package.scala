package com.scaladocs.examples

import cats._
import cats.implicits._

package object patternmatching {
  def getPage: Page = new Page {

    def canonicalPath = "scala/language/pattern_matching"
    def title = "Pattern Matching"
    def signature = FQSignature("")
    def metaDescription: String = """
    |Simple Scala Pattern Matching Examples.
    """.stripMargin.trim
    def description: Option[String] =
      """
      |Patten matching is a Scala language feature that allows you to specify different actions at runtime based on a value, type, structure or result of a custom extractor.
      """.stripMargin.trim.some
    def tags: List[Tag] = List()
    def links: List[Link] =
      List(Link("Pattern Matching Spec", "https://www.scala-lang.org/files/archive/spec/2.13/08-pattern-matching.html"))
    def children: Pages = Nil
    def examples: CodeExamples =
      List(
        CodeExample(
          title = "Matching on Value",
          description = "Using pattern matching to match on an exact value.".some,
          tags = List(),
          snippet = Code("""
          |
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Matching on Value",
          description = "Using pattern matching to match on an exact value.".some,
          tags = List(),
          snippet = Code("""
          |
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Matching on Type",
          description = "Using pattern matching to match on a type.".some,
          tags = List(),
          snippet = Code("""
          |
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Structural Matching",
          description = "Using pattern matching to match on structure.".some,
          tags = List(),
          snippet = Code("""
          |
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Wildcard Matching",
          description = "Using wild cards to match on any value.".some,
          tags = List(),
          snippet = Code("""
          |
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Pattern Matching with Guards",
          description = "Using guards to specify additional criteria for a pattern.".some,
          tags = List(),
          snippet = Code("""
          |import scala.util.Random
          |def onlyEven(value: Int) = value % 2 == 0
          |
          |Random.nextInt() match {
          |  // Bind the value of Random.nextInt() to `x` then use it in the guard.
          |  case x if onlyEven(x) => println(s"Found an even number: ${x}")
          |  case x if !onlyEven(x) => println(s"Found an odd number: ${x}")
          |
          |  // Case without a guard...also serves as catch all..
          |  case x => println("All numbers are even or odd...so this never gets executed.")
          |}
          """.stripMargin.trim)
        )
      )
  }

}
