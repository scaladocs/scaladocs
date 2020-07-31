package com.scaladocs.examples.option

import cats._
import cats.implicits._

import com.scaladocs.examples._

object NoneExamples {
  def getPage: Page = new Page {
    def canonicalPath: String = "scala/None.html"

    def title: String = "None"

    def signature: FQSignature = FQSignature("scala.None")

    def description: Option[String] = """
    |Represents the null-able case of an Option.
    |None is used to represent the abscence of a value.
    """.stripMargin.trim.some

    def tags: Tags = Nil

    def links: Links = Nil

    def children: Pages = Nil

    def examples: CodeExamples = List(
      CodeExample(
        title = "Constructing a None value",
        description = none,
        tags = Nil,
        snippet = Code("""
          |val resultA: Option[Int] = None // A would be Int
          |val resultB: Option[String] = None // A would be String
          |val resultC: Option[Double] = None // A would be Double
          |
          |println(resultA)
          |println(resultB)
          |println(resultC)
          """.stripMargin.trim)
      )
    )
  }
}
