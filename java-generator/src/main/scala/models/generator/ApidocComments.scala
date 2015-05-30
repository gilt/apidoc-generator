package models.generator

import lib.Constants

/**
 *
 * Author: jkenny
 * Date: 28/05/2015
 */
class ApidocComments(version: String, userAgent: Option[String]) {

  private val elements = Seq(
    Some(s"Generated by apidoc - ${Constants.ApidocUrl}"),
    Some(s"Service version: $version"),
    userAgent
  ).flatten

  val forClassFile: String = JavaUtil.textToComment(elements)
}
