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
      <div class="links">
        ${list.map(_.show).mkString("\n")}
      </div>
      """
    }
  }

  implicit val linksShow: Show[Link] = Show.show { link => 
    s"""
    <a href="${link.url}" target="_blank" rel="no-follow">${link.label}</a>
    """
  }


  implicit val listTag: Show[List[Tag]] = Show.show { list => 
    if (list.isEmpty) {
      s"<!-- No Tags Specified -->"
    } else {
      s"""
      <div class="example-tags">
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
    s"""
    <html>
      ${HtmlHead.replace("$PAGE_TITLE", page.title)}
      <body>
        <div class="container">
          ${HtmlHeader}
          <h2 class="example-title">${page.title.show}</h2>
          <h3 class="example-fqn-title">${page.signature.show}</h3>
          ${page.tags.show}
          <p class="example-description">
            ${page.description.map(_.show).getOrElse("")}
          </p>
          ${page.examples.map(_.show).mkString("\n\n")}
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
      <div class="example-versions">
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
      <div class="example-contributors">
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
    |  <pre><code class="code-example language-scala">
    |${code.value}
    |  </code></pre>
    |</div>
    """.stripMargin.trim
  }

  implicit val exampleShow: Show[CodeExample] = Show.show { example => 
    s"""
    <div class="example">
      <h3 class="example-header">${example.description.map(_.show).getOrElse("")}</h3>
      ${example.tags.show}
      ${example.versions.show}
      ${example.snippet.show}
      ${example.contributors.show}
    </div>
    """
  }


}
