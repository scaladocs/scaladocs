package com.scaladocs.examples.option

import cats._
import cats.implicits._

import com.scaladocs.examples._

object SomeExamples {
  def getPage: Page = new Page {
    def canonicalPath: String = "scala/Some.html"

    def title: String = "Some[+A]"

    def signature: FQSignature = FQSignature("scala.Some[+A]")

    def description: Option[String] =
      """
    |Represents the non-null case of an Option. Some indicates the precense of a value.
    """.stripMargin.trim.some

    def tags: Tags = Nil

    def links: Links = Nil

    def children: Pages = Nil

    def examples: CodeExamples = List(
      CodeExample(
        title = "Constructing a Some value",
        description = none,
        tags = Nil,
        snippet = Code("""
          |val resultA: Option[Int] = Some(100) 
          |val resultB: Option[String] = Some("Some Value") 
          |val resultC: Option[Double] = Some(100.000001) 
          |
          |println(resultA)
          |println(resultB)
          |println(resultC)
          """.stripMargin.trim)
      )
    )
  }
}
