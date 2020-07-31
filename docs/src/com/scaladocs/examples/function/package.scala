package com.scaladocs.examples

import cats._
import cats.implicits._

package object function {
  def getPage: Page = new Page {
    def canonicalPath: String = "scala/Function.html"

    def title: String = "Function"

    def metaDescription: String = """
    |Simple usage examles for Scala's Function Type. Compose, andThen, chain and more.
    """.stripMargin.trim

    def signature: FQSignature = FQSignature("scala.Function")

    def description: Option[String] = """
    |The function companion object contains helpers for functions.
    """.stripMargin.trim.some

    def tags: List[Tag] = List(Tag("Standard Library"))

    def links: List[Link] = List(
      Link("Scala Docs for Function", "https://www.scala-lang.org/api/current/scala/Function$.html"),
      Link("Source Code for Function", "https://github.com/scala/scala/blob/2.13.x/src/library/scala/Function.scala")
    )

    def examples: CodeExamples = List(
      CodeExample(
        title = "Function.chain",
        description =
          "Creates a function that pipes the result from one function to the next in order of the provided sequence.".some,
        tags = Nil,
        snippet = Code("""
        |def increment(x: Int) = x + 1
        |def double(x: Int) = x * 2
        |
        |Function.chain(Seq(increment, increment, double))
        |println(s"Plus Two and Double: ${plusTwoAndDouble(0)}")
        |
        |val doubleDoubleDouble = Function.chain(Seq(double, double, double))
        |println(s"Double Thrice: ${doubleDoubleDouble(100)}")
        """.stripMargin.trim)
      ),
      CodeExample(
        title = "Function.const",
        description = "Creates a function that ignored its input and returns a constant value.".some,
        tags = Nil,
        snippet = Code("""
        |val justOne: Int => Int = Function.const(42)
        |println(s"Just One: ${justOne(0)}")
        |
        |// The constant generated function is strict in its arguments.
        |lazy val sideEffect = { println("I'm a side-effect"); 999 }
        |println("Pre Calling Just 1")
        |println(s"Just One with Side Effect: ${justOne(sideEffect)}")
        """.stripMargin.trim)
      )
    )

    def children: Pages = Nil
  }
}
