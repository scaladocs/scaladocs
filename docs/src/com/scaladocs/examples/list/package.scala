package com.scaladocs.examples

import cats._
import cats.implicits._

package object list {
  def getPage: Page = new Page {

    def canonicalPath = "scala/collection/immutable/List.html"
    def title = "List"
    def signature = FQSignature("scala.collection.immutable.List[+A]")
    def description: Option[String] = """An immutable linked list of elements of type A.""".stripMargin.trim.some
    def tags: List[Tag] = List()
    def links: List[Link] =
      List(
        Link("Scala Docs for List", "https://www.scala-lang.org/api/current/scala/collection/immutable/List.html"),
        Link("Source Code for List", "https://github.com/scala/scala/blob/2.13.x/src/library/scala/collection/immutable/List.scala")
      )
    def children: Pages = Nil
    def examples: CodeExamples =
      List(
        CodeExample(
          title = "List.apply",
          description = "Building a list using the comanion object's apply".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.apply",
          description = "Building a list using the comanion object's apply".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.fill",
          description = "Build a list that is filled with the provided element.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.from",
          description = "Build a list from another collection.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.range",
          description = "Create a list with the given range.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.tabulate",
          description = "Create a list containing the values produced by a given function.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.unfold",
          description = "Create a list of values relative to some state.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "List.iterate",
          description = "Create a list of values resulting by repeated invocations of the function on a value.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "concat, ++",
          description = "Concatenate a list ".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "prependAll, ++:, :::",
          description = "Adds all elements of the list to another list".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "pepend, +:, ::",
          description = "Adds an element to the start of the list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "appendAll, :++",
          description = "Adds all elements of the list to the end of another list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "append, :+",
          description = "Adds an element to the end of the list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "collect",
          description = "Creates a list of elements transformed by the provided partial function.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "collectFirst",
          description =
            "Return an Option of the first transformed element defined by the partial function, if it exists. ".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "contains",
          description = "Tests if the given element is within the list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "corresponds",
          description = "Tets whether every element in the list corresponds to an element in another list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "distinct, distinctBy",
          description = "Retuns a list with just the distinct elements contained by the list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "exists",
          description = "Tests if at least one element in the list satisfies the given predicate.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "filter",
          description = "Create a list of all items matching the predicate.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "find, findLast",
          description = "Return an Option of the first element matching the predicate.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "flatMap",
          description = "Create a flattened list of elements transformed by the given function.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "map",
          description = "Create a list of elements transformed by the given function.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "flatten",
          description = "Remove one level of nesting from the given nested list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "fold",
          description = "Accumulate the result of applying a binary operation on all elements of the list.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "foldLeft",
          description =
            "Accumulate the result of applying a binary operation on all elements of the list, going from left to right.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "foldRight",
          description =
            "Accumulate the result of applying a binary operation on all elements of the list, going from right to left.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "foreach",
          description =
            "Apply the given function to each element in the list. This is typically used for side-effects.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "forall",
          description = "Test if all elements in the list hold for the given predicate.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "partition",
          description =
            "Create two list, one list for all elements satisfying the given predicate, and a second list for items not satisfying the given predicate.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "tapEach",
          description =
            "Applies a function to each element of the list, returning the input list. This is used for it's side-effects.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "zip",
          description = "Create a list of tuples, where corresponding elements of each list are matched up.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        ),
        CodeExample(
          title = "zipWithIndex",
          description = "Creates a list of tuples, where each element is matched with its index.".some,
          tags = List(),
          snippet = Code("""""".stripMargin.trim)
        )
      )
  }

}
