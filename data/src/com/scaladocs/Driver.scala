package com.scaladocs 

import cats._
import cats.implicits._

import com.scaladocs.io.Logger
import java.nio.file.Paths
import java.nio.file.Path
import java.nio.file.Files

object Driver extends App {
  val root = Paths.get("").toAbsolutePath

  // Add examples to this list to generate pages.
  val exports = List(
    examples.either.getPage
  )

  // Copy files required by the templates:
  locally[Unit] {
    val destinationClientPath = root.resolve("dest/")
    val htmlRescourcesPath = root.resolve("data/resources/html/")

    Files
      .walk(htmlRescourcesPath)
      .filter({ f => 
        val notHTML = !f.getFileName().toString.endsWith(".html") 
        val notRootDirectory = f.compareTo(htmlRescourcesPath) != 0
        notHTML && notRootDirectory
      })
      .forEach(source => {
        val fileName = source.getFileName
        val destination = destinationClientPath.resolve(fileName)
        io.copy(source, destination)
      })
  }

  // Export the standalone Examples:
  locally[Unit] { 
    import html.StandaloneExamples._
    Logger.info(s"Starting export for all pages. Exporting ${exports.size} Pages")
    val outputPathPrefix = root.resolve("dest/examples/")
    exports.foreach { page => 
      val pageDestination = outputPathPrefix.resolve(page.canonicalPath)
      io.putContents(pageDestination, page.show)
    }
  }
}
