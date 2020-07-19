package com.scaladocs 

import cats._
import cats.implicits._

object Driver extends App {
  val eitherPage = examples.either.getPage
  // TODO: Add Steps to Load Template Partials
  println(eitherPage.show)
}
