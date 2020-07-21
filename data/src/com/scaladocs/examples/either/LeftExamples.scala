package com.scaladocs.examples.either

import cats._
import cats.implicits._

import com.scaladocs.examples._

object LeftExamples {
  def getPage: Page = new Page {
    def canonicalPath: String = "scala/util/Left.html"

    def title: String = "Left[+A]"

    def signature: FQSignature = FQSignature("scala.util.Left[+A]")


    def description: Option[String] = """
    | Represents the Left value of the Either[+A, +B] type.
    | Typically Left is used to represent an error type, but it can represent 
    | an alternative of type with two possible types.
    """.stripMargin.trim.some

    def tags: Tags = Nil

    def links: Links = Nil

    def children: Pages = Nil

    def examples: CodeExamples =  List(
      CodeExample(
        description = "Constructing a Left value".some,
        tags = Nil,
        snippet = Code("""
          |import scala.util.{Either, Left}
          |
          |val resultA: Either[Int, Nothing] = Left(100) 
          |val resultB: Either[String, Nothing] = Left("Some Failure!") 
          |val resultC: Either[Double, Nothing] = Left(100.000001) 
          |
          |println(resultA)
          |println(resultB)
          |println(resultC)
          """.stripMargin.trim
        )
      )
    )
  }
}
