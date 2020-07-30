package com.scaladocs

package object examples {
  case class VersionNumber(val value: String) extends AnyVal
  case class Code(val value: String) extends AnyVal
  case class FQSignature(val value: String) extends AnyVal

  type CodeExamples = List[CodeExample]
  type Contributors = List[Contributor]
  type Links = List[Link]
  type Tags = List[Tag]
  type Pages= List[Page]
  type VersionNumbers = List[VersionNumber]
}
