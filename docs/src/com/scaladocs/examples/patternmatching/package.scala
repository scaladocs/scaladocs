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
          |import scala.util.Random
          | 
          |// Match Numbers to a Word
          |Math.abs(Random.nextInt() % 10) match {
          |  case 0 => println("Cero")
          |  case 1 => println("Uno")
          |  case 2 => println("Dos")
          |  case 3 => println("Tres")
          |  case 4 => println("Quatro")
          |  case 5 => println("Cinco")
          |  case 6 => println("Seis")
          |  case 7 => println("Siete")
          |  case 8 => println("Ocho")
          |  case 9 => println("Nueve")
          |}
          |
          |// Match strings to values:
          |val choice = "pizza"
          |choice match {
          |  case "not-pizza" => println("Chose Not Pizza!")
          |  case "salad" => println("Chose Salad!")
          |  case "pizza" => println("Chose Pizza!")
          |  case "ice cream" => println("Chose Ice Cream!")
          |  // Catch all case for values not defined:
          |  case _ => println("Chose Something Else")
          |}
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
          |val list: List[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
          |
          |def printListByTwo(input: List[Int]): Unit = input match {
          |  // Use structural matching to determine that it's the end of the list:
          |  case Nil => println("End")
          |
          |  // Use structural matching to extract the last element:
          |  case head :: Nil => 
          |    println(head)
          |    println("End")
          |
          |  // Use structural matchin to bind the first two elements to `head` and `next`:
          |  case head :: next :: rest => 
          |    println(head)
          |    println(next)
          |    println("----")
          |    printListByTwo(rest)
          |}
          |
          |printListByTwo(list)
          """.stripMargin.trim)
        ),
        CodeExample(
          title = "Wildcard Matching",
          description = "Using wild cards to match on any value.".some,
          tags = List(),
          snippet = Code("""
          |val pizzaA = Some("Veggie Lover's")
          |val pizzaB = Some("Meat Lover's")
          |
          |def describeOrder(first: Option[String], second: Option[String]) = {
          |  println(s"\nMatching: ${first} ${second}")
          |  (first, second) match {
          |    case (Some("Meat Lover's"), Some("Meat Lover's")) => println("Double the Meat Lover's")
          |    case (Some("Veggie Lover's"), Some("Veggie Lover's")) => println("Double the Veggie Lover's")
          |
          |    // Using _ as a wild card for any value within the second Some:
          |    case (Some("Veggie Lover's"), Some(_)) => println("2 Pizzas with at least one Veggie Lover's")
          |    case (Some("Meat Lover's"), Some(_)) => println("2 Pizzas with at least one Meat Lover's")
          |
          |    // Using _ as a wild card for any value in the second position of the tuple:
          |    case (Some("Veggie Lover's"), _) => println("One Veggie Lover's")
          |    case (Some("Meat Lover's"), _) => println("One Meat Lover's")
          |
          |    // Catch all for any combination we did not define, ie: (None, None)
          |    case (fst, snd) => println(s"Catch-all....(${fst},${snd})")
          |  }
          |}
          |
          |describeOrder(pizzaA, pizzaB)
          |describeOrder(pizzaA, None)
          |describeOrder(pizzaA, Some("Chorizo"))
          |describeOrder(pizzaB, pizzaA)
          |describeOrder(pizzaB, Some("Anchovie"))
          |describeOrder(pizzaB, None)
          |describeOrder(Some("Chorizo"), Some("Anchovie"))
          |describeOrder(None, None)
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
