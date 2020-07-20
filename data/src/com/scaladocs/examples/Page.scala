package com.scaladocs.examples

trait Page {
  def canonicalPath: String
  def title: String 
  def signature: FQSignature
  def description: Option[String]
  def tags: Tags
  def links: Links
  def examples: CodeExamples
}

object Page {
  implicit val fqSignatureShow: Show[FQSignature] = Show.show(_.value) 
  implicit val linksShow: Show[Link] = Show.show(link => s"${link.label}: ${link.url}")
  implicit val listTag: Show[List[Tag]] = Show.show(list => list.map(_.show).mkString(", "))
  implicit val tagShow: Show[Tag] = Show.show(tag => s"${tag.label}: ${tag.url}")
  implicit val showInstance: Show[Page] = Show.show { page => 
    s"""
    Title: ${page.title}
    Signature: ${page.signature.show}
    Description: ${page.description.show}
    Tags: ${page.tags.show}
    Links: ${page.links.show}
    Examples: ${page.examples.show}
    """
  }

  implicit val versionNumberShow: Show[VersionNumber] = Show.show(_.value) 
  implicit val contributorShow: Show[Contributor] = Show.show(c => s"${c.label}(${c.url})") 
  implicit val codeShow: Show[Code] = Show.show(_.value) 
  implicit val exampleShow: Show[CodeExample] = Show.show { example => 
    s"""
      Versions: ${example.versions.show}
      Description: ${example.description.show}
      Contributors: ${example.contributors.show}
      Tags: ${example.tags.show}
      Snippet: ${example.snippet.show}
    """
  }


}
