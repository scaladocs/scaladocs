package com.scaladocs.http

import com.sun.net.httpserver._
import java.net.InetSocketAddress
import java.nio.file.{Path, Paths, Files}
import java.util.concurrent.Executors

import scala.collection.JavaConverters._
import scala.io.StdIn

/** This is a development server use to serve the generated assets from `docs/` from `build` */ 
object DevServer extends App {
  val port = new InetSocketAddress(8000)
  val server = HttpServer.create(port, 0)
  val context = server.createContext("/", new RequestHandler())
  server.setExecutor(null)
  server.start()

  println("Press any key to exit")
  StdIn.readLine()
  println("Exiting...")
  server.stop(0)

  class RequestHandler extends HttpHandler {
    val root = Paths.get("build/").toAbsolutePath

    def handle(request: HttpExchange): Unit = {
      println(s"Serving: ${request.getRequestURI()}")
      val response = write(request)(_, _)
      getContents(request.getRequestURI().toString) match {
        case Left((statusCode, payload)) => response(statusCode, payload)
        case Right(payload) => response(200, payload)
      }
    }

    private def write(request: HttpExchange)(statusCode: Int, payload: String): Unit = {
      val payloadBytes = payload.getBytes
      val response = request.getResponseBody
      request.sendResponseHeaders(statusCode, payloadBytes.length)
      response.write(payloadBytes)
      response.close
    }

    private def getContents(path: String): Either[(Int, String), String] = {
      path match {
        case "/" => getContents("/index.html")
        case path if exists(path) => Right(read(path))
        case _ => Left(404 -> "File does not exist!")
      }
    }

    private def exists(path: String): Boolean = Files.exists(resolve(path))
    private def read(path: String): String = Files.readAllLines(resolve(path)).asScala.mkString("\n")
    private def resolve(path: String): Path  = root.resolve(path.substring(1)).toAbsolutePath()
  }
}
