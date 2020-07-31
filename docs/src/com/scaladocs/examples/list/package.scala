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
          snippet = Code(
            """
            |// List of Ints:
            |val myIntList = List[Int](1, 2, 3, 4, 5, 6)
            |println(myIntList)
            |
            |// List of Strings: 
            |val myStringList = List[String]("First", "Second", "Third", "Fourth")
            |println(myStringList)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.fill",
          description = "Build a list that is filled with the provided element.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code(
            """
            |val magicNumber: Int = 42
            |
            |println("\nOne Dimension Filled List:")
            |val tenMagicNumbers: List[Int] = List.fill(10)(magicNumber)
            |println(s"List has ${tenMagicNumbers.size} elements.")
            |println(tenMagicNumbers)
            |
            |println("\nTwo Dimension Filled List:")
            |val dimension1 = 2
            |val dimension2 = 3
            |val twoDimensionList: List[List[Int]] = List.fill(dimension1, dimension2)(magicNumber)
            |println(twoDimensionList)
            |
            |println("\nThree Dimension Filled List:")
            |val dimension3 = 1
            |val threeDimensionList: List[List[List[Int]]] = List.fill(dimension1, dimension2, dimension3)(magicNumber)
            |println(threeDimensionList)
            |
            |// Fill is defined for up to 5 parameters (dimensions).
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.from",
          description = "Build a list from another collection.".some,
          tags = List(Tag("Comanion Object"), Tag("2.13.x")),
          snippet = Code(
            """
            |// Available starting with: 2.13.x
            |val myList: List[String] = List.from(Array("a", "b", "c"))
            |println(myList)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.range",
          description = "Create a list with the given range.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code(
            """
            |val rangeA: List[Int] = List.range(1, 10)
            |println(s"One to Ten: ${rangeA}")
            |
            |val rangeByTwo: List[Long] = List.range(1, 10, 2)
            |println(s"One to Ten by Two: ${rangeByTwo}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.tabulate",
          description = "Create a list containing the values produced by a given function.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code(
            """
            |println("\nTabulate the position of each element:")
            |val numberOfElements = 4 
            |def providerForIndex(index: Int): Int = index
            |val numberLine: List[Int] = List.tabulate(numberOfElements)(providerForIndex)
            |println(numberLine)
            |
            |println("\nTabulate the position of each element of a two dimension grid:")
            |val numberOfRows = 4
            |val numberOfCols = 4
            |def gridProvider(x: Int, y: Int): Int = y + (x * numberOfElements)
            |val grid: List[List[Int]] = List.tabulate(numberOfRows, numberOfCols)(gridProvider)
            |println(grid)
            |
            |// List.tabulate supports up to 5 paramaters, or 5 nested list dimensions.
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.unfold",
          description = "Create a list of values relative to some state.".some,
          tags = List(Tag("Comanion Object"), Tag("2.13.x")),
          snippet = Code(
            """
            |// List.unfold is only available starting with Scala 2.13.x
            |val initial: Int = 65 // ASCII A
            |def getNext(state: Int) = {
            |  if (state > (initial + 25)) None
            |  else Some((state.toChar, state + 1))
            |}
            |val alphabet: List[Char] = List.unfold(initial)(getNext)
            |println(alphabet)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "List.iterate",
          description = "Create a list of values resulting by repeated invocations of the function on a value.".some,
          tags = List(Tag("Comanion Object")),
          snippet = Code(
            """
            |def doublePrevious(value: Int) = value * 2
            |val initialValue = 1
            |val numberOfIterations = 10
            |val tenDoubledNumbers: List[Int] = List.iterate(initialValue, numberOfIterations)(doublePrevious)
            |println(tenDoubledNumbers)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "concat, ++",
          description = "All all elements of another list to the end of a list.".some,
          tags = List(),
          snippet = Code(
            """
            |val listA = List(1, 2, 3)
            |val listB = List(50, 60, 70)
            |val result = listA ++ listB
            |println(s"listA: ${listA}") // Original list unmodified
            |println(s"listB: ${listB}") // Original list unmodified
            |println(s"result: ${result}") // New list with elements from both original lists
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "prependAll, ++:, :::",
          description = "Add all elements of a collection to the list.".some,
          tags = List(),
          snippet = Code(
            """
            |val collectionA = Vector(1, 2, 3)
            |val listB = List(50, 60, 70)
            |val resultA: Vector[Int] = listB  ++: collectionA // Prepend values of list into collection.
            |val resultB: List[Int] = collectionA ++: listB    // Prepend values of collection into list.
            |
            |println(s"collectionA: ${collectionA}") // Original vector unmodified
            |println(s"listB: ${listB}") // Original list unmodified
            |println(s"resultA: ${resultA}") // Vector
            |println(s"resultB: ${resultB}") // List
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "pepend, +:, ::",
          description = "Adds an element to the start of the list.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List("b", "c")
            |val updatedListA = "a" +: list
            |val updatedListB = "a" :: list
            |println(updatedListA)
            |println(updatedListB)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "appendAll, :++",
          description = "Adds all elements of the list to the end of another list.".some,
          tags = List(Tag("2.13.x")),
          snippet = Code(
            """
            |val collectionA = Vector(1, 2, 3)
            |val listB = List(50, 60, 70)
            |val resultA: List[Int] = listB  :++ collectionA  // Append values of collection into list.
            |val resultB: Vector[Int] = collectionA :++ listB // Append values of list into collection.
            |
            |println(s"collectionA: ${collectionA}") // Original vector unmodified
            |println(s"listB: ${listB}") // Original list unmodified
            |println(s"resultA: ${resultA}") // List
            |println(s"resultB: ${resultB}") // Vector
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "append, :+",
          description = "Adds an element to the end of the list.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List("a", "b")
            |val updatedList = list :+ "c"
            |println(updatedList)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "collect",
          description = "Creates a list of elements transformed by the provided partial function.".some,
          tags = List(),
          snippet = Code(
            """
            |val importantNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
            |val superImportantNumbers = importantNumbers.collect {
            |  // This partial function behaves as map and filter operations in one step.
            |  case num if (num % 2 == 0) => s"Super #${num}"
            |}
            |println(superImportantNumbers + "\n")
            |
            |val allNumbers = importantNumbers.collect {
            |  // A partial function defined for all inputs, is equivalent to
            |  // a normal list.map operation.
            |  case num => s"Just #${num}"
            |}
            |println(allNumbers)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "collectFirst",
          description =
            "Return an Option of the first transformed element defined by the partial function, if it exists. ".some,
          tags = List(),
          snippet = Code(
            """
            |val importantNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
            |
            |val firstSuperNumber = importantNumbers.collectFirst {
            |  // This partial function behaves as map and filter operations in one step.
            |  case num if (num % 2 == 0) => s"Super #${num}"
            |}
            |println(s"Super Number Found: ${firstSuperNumber}")
            |
            |val noSuperNumber = importantNumbers.collectFirst {
            |  case num if num > 10 => s"Super #${num}"
            |}
            |println(s"Super Number Found: ${noSuperNumber}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "contains",
          description = "Tests if the given element is within the list.".some,
          tags = List(),
          snippet = Code(
            """
            |val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
            |val hasTen = numbers.contains(10)
            |println(s"hasTen: ${hasTen}")
            |
            |val hasOneHundred = numbers.contains(100)
            |println(s"hasOneHundred: ${hasOneHundred}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "corresponds",
          description = "Tets whether every element in the list corresponds to an element in another list.".some,
          tags = List(),
          snippet = Code(
            """
            |val listA = List(1, 2, 3)
            |val listB = List(1, 2, 3)
            |val listC = List(11, 22, 33)
            |
            |def correspondByValue[A, B](a: A, b: B) = a == b
            |
            |val aToB = listA.corresponds(listB)(correspondByValue)
            |println(s"listA and listB: ${aToB}")
            |
            |val aToC = listA.corresponds(listC)(correspondByValue)
            |println(s"listA and listC: ${aToC}")
            |
            |def correspondByTranslation(a: Int, b: Int) = a == (b / 11)
            |val bToC = listb.corresponds(listC)(correspondByTranslation)
            |println(s"listB and listC: ${bToC}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "distinct",
          description = "Retuns a list with just the distinct elements contained by the list.".some,
          tags = List(),
          snippet = Code(
            """
            |val numbers = List(1, 2, 3, 1, 2, 3, 1, 2, 3)
            |val distinct = numbers.distinct
            |println(distinct)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "distinctBy",
          description = "Retuns a list with just the distinct elements contained by the list.".some,
          tags = List(Tag("2.13.x")),
          snippet = Code(
            """
            |val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
            |// Returns distinct values defined by the co-domain of the provided function.
            |val distinctBy = numbers.distinctBy { value => value % 3 }
            |println(distinctBy)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "exists",
          description = "Tests if at least one element in the list satisfies the given predicate.".some,
          tags = List(),
          snippet = Code(
            """
            |def containsMagic(candidate: Int) = candidate % 42 == 0
            |val listA = List(1, 2, 4, 8, 16, 32, 64)
            |val resultA = listA.exists(containsMagic)
            |println(s"Contains Some Magic: ${resultA}")
            |
            |val listB = List(1, 2, 4, 8, 16, 32, 84)
            |val resultB = listB.exists(containsMagic)
            |println(s"Contains Some Magic: ${resultB}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "filter",
          description = "Create a list of all items matching the predicate.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
            |val smallNumers = list.filter(_ < 5)
            |println(s"Small Numbers: ${smallNumers}")
            |
            |val largeNumers = list.filter(_ > 5)
            |println(s"Large Numbers: ${largeNumers}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "find",
          description = "Return an Option of the first element matching the predicate.".some,
          tags = List(),
          snippet = Code(
            """
            |case class Data(value: Int, position: Int)
            |
            |val list = List(
            |  Data(1,1),
            |  Data(2,2),
            |  Data(1,3),
            |  Data(2,4)
            |)
            |
            |val result = list.find(_.value == 2)
            |println(s"Result of Find: ${result}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "findLast",
          description = "Return an Option of the last element matching the predicate.".some,
          tags = List(Tag("2.13.x")),
          snippet = Code(
            """
            |case class Data(value: Int, position: Int)
            |
            |val list = List(
            |  Data(1,1),
            |  Data(2,2),
            |  Data(1,3),
            |  Data(2,4)
            |)
            |
            |val result = list.findLast(_.value == 2)
            |println(s"Result of Find Last: ${result}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "flatMap",
          description = "Create a flattened list of elements transformed by the given function.".some,
          tags = List(),
          snippet = Code(
            """
            |def toPostiveNegative(value: Int) = List(-value, value)
            |
            |val list = List(1, 2, 3)
            |val positiveNegativeList = list.flatMap(toPostiveNegative)
            |println(s"Result: ${positiveNegativeList}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "map",
          description = "Create a list of elements transformed by the given function.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List(65, 66, 67) // ASCII values for ABC
            |
            |val resultA = list.map(_.toChar)
            |println(s"Result A: ${resultA}")
            |
            |val resultB = list.map { x => (x + 32).toChar } // Lower Case
            |println(s"Result B: ${resultB}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "flatten",
          description = "Remove one level of nesting from the given nested list.".some,
          tags = List(),
          snippet = Code(
            """
            |val listOfLists = List(List(1,2,3), List(10, 20, 30), List(100, 200, 300))
            |val flattened = listOfLists.flatten
            |println(flattened)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "fold",
          description = "Accumulate the result of applying a binary operation on all elements of the list.".some,
          tags = List(),
          snippet = Code(
            """
            |// fold accumulates values into the same type as is contained by the list. 
            |// See foldLeft to accumulate into a different type.
            |val list = List(5, 4, 3, 2, 1)
            |val result = list.fold(1)(_ * _)
            |println(result)
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "foldLeft",
          description =
            "Accumulate the result of applying a binary operation on all elements of the list, going from left to right.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List(5, 4, 3, 2, 1)
            |
            |// Accumualte values into a new list by prepending value from left to right.
            |val resultA = list.foldLeft(Nil: List[Int]){ (accumulator, nextValue) =>
            |  nextValue :: accumulator
            |}
            |println(s"Accumulate into new list: ${resultA}")
            |
            |// Accumualte values into a CSV
            |// Note: equivalent to `list.mkString(", ")`
            |val resultB = list.foldLeft(""){ (accumulator, nextValue) =>
            |  if (accumulator == "") s"${nextValue}"
            |  else s"${accumulator}, ${nextValue}"
            |}
            |println(s"Accumulate into a string: ${resultB}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "foldRight",
          description =
            "Accumulate the result of applying a binary operation on all elements of the list, going from right to left.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List(5, 4, 3, 2, 1)
            |
            |// Accumualte values into a new list by prepending value from right to left.
            |val resultA = list.foldRight(Nil: List[Int]){ (nextValue, accumulator) =>
            |  nextValue :: accumulator
            |}
            |println(s"Accumulate into new list: ${resultA}")
            |
            |// Accumualte values into a CSV
            |// Note: equivalent to `list.mkString(", ")`
            |val resultB = list.foldRight(""){ (nextValue, accumulator) =>
            |  if (accumulator == "") s"${nextValue}"
            |  else s"${nextValue}, ${accumulator}"
            |}
            |println(s"Accumulate into a string: ${resultB}")
            """.stripMargin.trim
          )
        ),
        CodeExample(
          title = "foreach",
          description =
            "Apply the given function to each element in the list. This is typically used for side-effects.".some,
          tags = List(),
          snippet = Code(
            """
            |val list = List(1, 2, 3, 4, 5)
            |list.foreach(value => println(s"Value is: ${value}"))
            """.stripMargin.trim
          )
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
