package com.scaladocs.html

import cats._
import cats.implicits._

import com.scaladocs.examples._
import com.scaladocs.io

object JsonIndex {
  // TODO: Use something like circe to encode JSON object
  implicit val listPageShowInstance: Show[List[Page]] = Show.show { list =>
    list.map(_.show).mkString("[", ",\n", "]")
  }

  implicit val pageShowInstance: Show[Page] = Show.show { page =>
    val tokens = page.signature.value.split("\\.")
    val packagePrefix = tokens.init.mkString(".")
    val title = page.signature.value match {
      case "" => page.title
      case _ => tokens.last
    }

    s"""
    {
      title: "${title}",
      package: "${packagePrefix}",
      url: "/examples/${page.canonicalPath.show}",
      children: ${page.children.show}
    }
    """
  }
}
