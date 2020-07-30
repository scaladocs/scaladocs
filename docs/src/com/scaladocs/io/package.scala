package com.scaladocs

import scala.io.Source
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import java.io.FileInputStream
import java.io.BufferedInputStream
import java.io.InputStreamReader
import java.io.StringReader
import java.io.ByteArrayInputStream

package object io {
  def getContents(resourceRelativePath: String): String = {
    Source.fromResource(resourceRelativePath)
      .getLines
      .mkString("\n")
  }

  def putContents(destination: Path, contents: String) = {
    Logger.info(s"Writing content to ${destination}")
    val parentDirectories = destination.getParent
    Files.createDirectories(parentDirectories)
    if (Files.exists(destination)) {
      Files.delete(destination)
    }
    Files.copy(new ByteArrayInputStream(contents.getBytes), destination)
  }

  def copy(source: Path, destination: Path) = {
    Logger.info(s"Copying ${source} to ${destination}")
    if (Files.exists(destination)) {
      Files.delete(destination)
    }
    Files.copy(source, destination)
  }

  object Logger {

    def debug(message: String*): Unit = writeWithTag("DEBUG")(message: _*)
    def error(message: String*): Unit = writeWithTag("ERROR")(message: _*)
    def info(message: String*): Unit = writeWithTag("INFO")(message: _*)

    private def tag(value: String) = s"[$value]"

    private def writeWithTag(tagValue: String)(message: String*): Unit = {
      val logTag = tag(tagValue)
      write(message.map(m => s"${logTag} ${m}"): _*)
    }

    private def write(message: String*): Unit = {
      message.foreach(println)
    }
  }
}

