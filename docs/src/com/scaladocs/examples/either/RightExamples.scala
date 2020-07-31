package com.scaladocs.examples.either

import cats._
import cats.implicits._

import com.scaladocs.examples._

object RightExamples {
  def getPage: Page = new Page {
    def canonicalPath: String = "scala/util/Right.html"

    def title: String = "Right[+B]"

    def metaDescription: String = """
    | Simple usage examples for Scala's Right type. How to construct a Right type.
    """.stripMargin.trim

    def signature: FQSignature = FQSignature("scala.util.Right[+B]")

    def description: Option[String] = """
    | Represents the `Right` value of the Either[+A, +B] type.
    | Typically Right is used to represent a success result, but it can represent 
    | an alternative of type with two possible types.
    """.stripMargin.trim.some

    def tags: Tags = Nil

    def links: Links = Nil

    def children: Pages = Nil

    def examples: CodeExamples = List(
      CodeExample(
        title = "Constructing a Right value",
        description = none,
        tags = Nil,
        snippet = Code("""
          |import scala.util.{Either, Right}
          |
          |val resultA: Either[Nothing, Int] = Right(100) 
          |val resultB: Either[Nothing, String] = Right("Success at last!") 
          |val resultC: Either[Nothing, Double] = Right(100.000001) 
          |
          |println(resultA)
          |println(resultB)
          |println(resultC)
          """.stripMargin.trim)
      )
    )
  }
}
