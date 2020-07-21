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
    examples.either.getPage,
    examples.option.getPage
  )

  // Copy files required by the templates:
  locally[Unit] {
    val destinationClientPath = root.resolve("dest/")
    val htmlRescourcesPath = root.resolve("data/resources/html/")

    Files
      .walk(htmlRescourcesPath)
      .filter({ f => 
        val fileName = f.getFileName.toString

        val isIndex  = fileName.endsWith("index.html")
        val notHTML = !fileName.endsWith(".html") 
        val notSearchIndex = !fileName.endsWith("search-index.js")
        val notRootDirectory = f.compareTo(htmlRescourcesPath) != 0

        isIndex || (notHTML && notSearchIndex && notRootDirectory)
      })
      .forEach(source => {
        val fileName = source.getFileName
        val destination = destinationClientPath.resolve(fileName)
        io.copy(source, destination)
      })
  }
  
  // Export the index of examples:
  locally[Unit] {
    import html.JsonIndex._
    Logger.info(s"Creating Index for ${exports.size} Pages")
    val destination = root.resolve("dest/search-index.js")
    io.putContents(destination, s"const configuration = ${exports.show}")
  }

  // Export the standalone examples:
  locally[Unit] { 
    import html.StandaloneExamples._
    Logger.info(s"Starting export for all pages. Exporting ${exports.size} Pages")
    val outputPathPrefix = root.resolve("dest/examples/")
    exports.foreach { page => 
      val pageDestination = outputPathPrefix.resolve(page.canonicalPath)
      io.putContents(pageDestination, page.show)

      page.children.foreach { child => 
        val childPageDestination = outputPathPrefix.resolve(child.canonicalPath)
        io.putContents(childPageDestination, child.show)
      }
    }
  }
}
