package com.scaladocs.html

import cats._ 
import cats.implicits._ 

import com.scaladocs.examples._
import com.scaladocs.io

object StandaloneExamples {
  lazy val HtmlHead = io.getContents("html/head.html")
  lazy val HtmlHeader = io.getContents("html/header.html")
  lazy val HtmlFooter = io.getContents("html/footer.html")

  implicit val fqSignatureShow: Show[FQSignature] = Show.show(_.value) 

  implicit val listLinkShow: Show[List[Link]] = Show.show { list => 
    if (list.isEmpty) {
      s"<!-- No Links -->"
    } else {
      s"""
      <h2 class="bolder">Related Resources:</h2>
      <ul class="links">
        ${list.map(_.show).mkString("\n")}
      </ul>
      """
    }
  }

  implicit val linksShow: Show[Link] = Show.show { link => 
    val target = if (link.external) "target=\"_blank\"" else ""
    s"""
    <li class="link">
      <a href="${link.url}" ${target} rel="no-follow">${link.label}</a>
    </li>
    """
  }


  implicit val listTag: Show[List[Tag]] = Show.show { list => 
    if (list.isEmpty) {
      s"<!-- No Tags Specified -->"
    } else {
      s"""
      <div class="tags">
        ${list.map(_.show).mkString("\n")}
      </div>
      """
    }
  } 

  implicit val tagShow: Show[Tag] = Show.show { 
    case Tag(label, None) => 
      s"""
      <span class="tag">${label}</span>
      """

    case Tag(label, Some(url)) => 
      s"""
      <span class="tag with-link"><a href="${url}">${label}</a></span>
      """
  }

  implicit val showInstance: Show[Page] = Show.show { page => 
    val relatedPages: List[Link] = page.children.map { child => 
      Link(child.signature.value, "/examples/" + child.canonicalPath, external = false)
    }

    s"""
    <html>
      ${HtmlHead.replace("$PAGE_TITLE", page.title)}
      <body>
        <div class="container">
          ${HtmlHeader}
          <h1 class="title">${page.title.show}</h1>
          <h2 class="subtitle">${page.signature.show}</h2>
          ${page.tags.show}
          <p class="description">
            ${page.description.map(_.show).getOrElse("")}
          </p>
          <h2 class="examples-section-header">Examples:</h2>
          ${page.examples.map(_.show).mkString("\n\n")}
          ${relatedPages.show}
          ${page.links.show}
        </div>
        ${HtmlFooter}
      </body>
    </html>
    """ 
  }

  implicit val listVersionNumber: Show[List[VersionNumber]] = Show.show { list => 
    if (list.isEmpty) {
      s"<!-- No Versions Specified -->"
    } else {
      s"""
      <div class="versions">
        ${list.map(_.show).mkString("\n")}
      </div>
      """
    }
  }

  implicit val versionNumberShow: Show[VersionNumber] = Show.show { version =>
    s"""
    <span class="tag">${version.value}</span>
    """
  }

  implicit val listContributorShow: Show[List[Contributor]] = Show.show { list =>
    if (list.isEmpty) {
      s"<!-- No Contributors Defined -->"
    } else {
      s"""
      <div class="contributors">
        ${list.map(_.show).mkString("\n")}
      </div>
      """
    }
  }

  implicit val contributorShow: Show[Contributor] = Show.show { 
    case Contributor(label, Some(url)) =>
      s"""
      <span class="contributor">
        <a href="${url}" rel="no-follow" target="_blank">
          ${label}
        </a>
      </span>
      """
    case Contributor(label, None) => 
      s"""
      <span class="contributor">
        ${label}
      </span>
      """
  } 

  implicit val codeShow: Show[Code] = Show.show { code => 
    s"""
    |<div data-scalafiddle data-theme="dark">
    |  <pre><code class="snippet language-scala">
    |${code.value}
    |  </code></pre>
    |</div>
    """.stripMargin.trim
  }

  implicit val exampleShow: Show[CodeExample] = Show.show { example => 
    s"""
    <div class="example">
      <h3 class="header">${example.title.show}</h3>
      ${example.description.map { description =>
        "<p>" + description.show +"</p>"
      }.getOrElse("")}
      ${example.tags.show}
      ${example.versions.show}
      ${example.snippet.show}
      ${example.contributors.show}
    </div>
    """
  }
}
