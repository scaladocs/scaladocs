package com.scaladocs.examples

import cats._
import cats.implicits._

package object either {
  def getPage: Page = new Page {
    val title = "Either"
    def signature= FQSignature("scala.util.Either[+A, +B]")
    def description: Option[String] = None
    def tags: List[Tag] = List.empty
    def links: List[Link] = List.empty
    def examples: CodeExamples = List(
      CodeExample(
        description = Some("Basic Usage"), 
        tags = List(Tag("Abc", "http://".some)),
        snippet = Code("""
          |println("Hello World")
          |println("Hello World...Again")
          """.stripMargin.trim
        )
      )
    )
  }
}
