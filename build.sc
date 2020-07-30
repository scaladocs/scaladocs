import mill._, scalalib._, scalafmt._

object docs extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.13.1"
  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:2.0.0",
    ivy"org.typelevel::cats-effect:2.1.4"
  )
}

object http extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.13.1"
}
