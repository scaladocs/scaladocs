package com.scaladocs.examples

case class CodeExample(
  versions: VersionNumbers = List.empty[VersionNumber],
  description: Option[String] = None,
  contributors: Contributors = List.empty[Contributor],
  tags: Tags = List.empty[Tag],
  snippet: Code 
)
