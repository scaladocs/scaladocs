package com.scaladocs.examples

trait Page {
  def canonicalPath: String
  def title: String 
  def signature: FQSignature
  def description: Option[String]
  def tags: Tags
  def links: Links
  def examples: CodeExamples
  def children: Pages
}
