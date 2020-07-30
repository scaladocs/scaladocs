package com.scaladocs.examples

import cats._
import cats.implicits._

package object option {
   def getPage: Page = new Page {
    def canonicalPath = "scala/Option.html"

    val title = "Option"

    def signature= FQSignature("scala.Option[+A]")

    def description: Option[String] = """
    |Option type represents a value that may or may not be present. 
    |It is often used to safeguard against otherwise nullable operations.
    """.stripMargin.trim.some

    def tags: List[Tag] = List(
      Tag("Standard Library")
    )

    def links: List[Link] = List(
      Link("Official Docs for Option", "https://www.scala-lang.org/api/2.13.1/scala/Option.html")
    )

    def children: Pages = List(
      SomeExamples.getPage,
      NoneExamples.getPage
    )

    def examples: CodeExamples = List(
      CodeExample(
        title = "Representing Nullable Operation", 
        description = none,
        tags = Nil,
        snippet = Code("""
          |import scala.util.{Random}
          |
          |val random = new Random()
          |
          |def nullableOperation() = {
          |  if (random.nextBoolean) {
          |    "Not null"
          |  } else {
          |    null
          |  }
          |}
          |
          |(1 to 5)
          |  .map(_ => nullableOperation())
          |  .map(nullable => Option(nullable)) // Create an instance of Option: Some or None
          |  .foreach(println)
          """.stripMargin.trim
        )
      )
    )
  }
 
}

