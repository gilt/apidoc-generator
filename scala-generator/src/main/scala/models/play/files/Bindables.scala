package scala.models.play.files

import cats.data.ValidatedNel
import scala.generator.ScalaService
import scala.models.play.components
import scala.models.play.Helpers._

class Bindables(scalaService: ScalaService) extends File {

  def name() = "Bindables.scala"
  def content(): ValidatedNel[String, String] =
    new components.Bindables(scalaService)
      .code
      .map { code =>
        s"""
          |package ${scalaService.namespaces.base}
          |
          |${code}
        """.clean
      }

}
