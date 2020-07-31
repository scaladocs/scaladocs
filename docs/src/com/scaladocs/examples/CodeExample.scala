package com.scaladocs.examples

case class CodeExample(
  title: String,
  versions: VersionNumbers = List.empty[VersionNumber],
  description: Option[String] = None,
  contributors: Contributors = List.empty[Contributor],
  links: Links = List.empty[Link],
  tags: Tags = List.empty[Tag],
  snippet: Code
)
