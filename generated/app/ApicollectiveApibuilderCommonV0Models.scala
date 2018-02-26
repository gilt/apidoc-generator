/**
 * Generated by API Builder - https://www.apibuilder.io
 * Service version: 0.13.29
 * apibuilder 0.14.3 app.apibuilder.io/apicollective/apibuilder-common/0.13.29/play_2_x_json
 */
package io.apibuilder.common.v0.models {

  case class Audit(
    createdAt: _root_.org.joda.time.DateTime,
    createdBy: io.apibuilder.common.v0.models.ReferenceGuid,
    updatedAt: _root_.org.joda.time.DateTime,
    updatedBy: io.apibuilder.common.v0.models.ReferenceGuid
  )

  case class Healthcheck(
    status: String
  )

  /**
   * Represents a reference to another model.
   */
  case class Reference(
    guid: _root_.java.util.UUID,
    key: String
  )

  case class ReferenceGuid(
    guid: _root_.java.util.UUID
  )

}

package io.apibuilder.common.v0.models {

  package object json {
    import play.api.libs.json.__
    import play.api.libs.json.JsString
    import play.api.libs.json.Writes
    import play.api.libs.functional.syntax._
    import io.apibuilder.common.v0.models.json._

    private[v0] implicit val jsonReadsUUID = __.read[String].map(java.util.UUID.fromString)

    private[v0] implicit val jsonWritesUUID = new Writes[java.util.UUID] {
      def writes(x: java.util.UUID) = JsString(x.toString)
    }

    private[v0] implicit val jsonReadsJodaDateTime = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateTimeParser
      dateTimeParser.parseDateTime(str)
    }

    private[v0] implicit val jsonWritesJodaDateTime = new Writes[org.joda.time.DateTime] {
      def writes(x: org.joda.time.DateTime) = {
        import org.joda.time.format.ISODateTimeFormat.dateTime
        val str = dateTime.print(x)
        JsString(str)
      }
    }

    private[v0] implicit val jsonReadsJodaLocalDate = __.read[String].map { str =>
      import org.joda.time.format.ISODateTimeFormat.dateParser
      dateParser.parseLocalDate(str)
    }

    private[v0] implicit val jsonWritesJodaLocalDate = new Writes[org.joda.time.LocalDate] {
      def writes(x: org.joda.time.LocalDate) = {
        import org.joda.time.format.ISODateTimeFormat.date
        val str = date.print(x)
        JsString(str)
      }
    }

    implicit def jsonReadsApibuilderCommonAudit: play.api.libs.json.Reads[Audit] = {
      (
        (__ \ "created_at").read[_root_.org.joda.time.DateTime] and
        (__ \ "created_by").read[io.apibuilder.common.v0.models.ReferenceGuid] and
        (__ \ "updated_at").read[_root_.org.joda.time.DateTime] and
        (__ \ "updated_by").read[io.apibuilder.common.v0.models.ReferenceGuid]
      )(Audit.apply _)
    }

    def jsObjectAudit(obj: io.apibuilder.common.v0.models.Audit): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "created_at" -> play.api.libs.json.JsString(_root_.org.joda.time.format.ISODateTimeFormat.dateTime.print(obj.createdAt)),
        "created_by" -> jsObjectReferenceGuid(obj.createdBy),
        "updated_at" -> play.api.libs.json.JsString(_root_.org.joda.time.format.ISODateTimeFormat.dateTime.print(obj.updatedAt)),
        "updated_by" -> jsObjectReferenceGuid(obj.updatedBy)
      )
    }

    implicit def jsonWritesApibuilderCommonAudit: play.api.libs.json.Writes[Audit] = {
      new play.api.libs.json.Writes[io.apibuilder.common.v0.models.Audit] {
        def writes(obj: io.apibuilder.common.v0.models.Audit) = {
          jsObjectAudit(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderCommonHealthcheck: play.api.libs.json.Reads[Healthcheck] = {
      (__ \ "status").read[String].map { x => new Healthcheck(status = x) }
    }

    def jsObjectHealthcheck(obj: io.apibuilder.common.v0.models.Healthcheck): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "status" -> play.api.libs.json.JsString(obj.status)
      )
    }

    implicit def jsonWritesApibuilderCommonHealthcheck: play.api.libs.json.Writes[Healthcheck] = {
      new play.api.libs.json.Writes[io.apibuilder.common.v0.models.Healthcheck] {
        def writes(obj: io.apibuilder.common.v0.models.Healthcheck) = {
          jsObjectHealthcheck(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderCommonReference: play.api.libs.json.Reads[Reference] = {
      (
        (__ \ "guid").read[_root_.java.util.UUID] and
        (__ \ "key").read[String]
      )(Reference.apply _)
    }

    def jsObjectReference(obj: io.apibuilder.common.v0.models.Reference): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "guid" -> play.api.libs.json.JsString(obj.guid.toString),
        "key" -> play.api.libs.json.JsString(obj.key)
      )
    }

    implicit def jsonWritesApibuilderCommonReference: play.api.libs.json.Writes[Reference] = {
      new play.api.libs.json.Writes[io.apibuilder.common.v0.models.Reference] {
        def writes(obj: io.apibuilder.common.v0.models.Reference) = {
          jsObjectReference(obj)
        }
      }
    }

    implicit def jsonReadsApibuilderCommonReferenceGuid: play.api.libs.json.Reads[ReferenceGuid] = {
      (__ \ "guid").read[_root_.java.util.UUID].map { x => new ReferenceGuid(guid = x) }
    }

    def jsObjectReferenceGuid(obj: io.apibuilder.common.v0.models.ReferenceGuid): play.api.libs.json.JsObject = {
      play.api.libs.json.Json.obj(
        "guid" -> play.api.libs.json.JsString(obj.guid.toString)
      )
    }

    implicit def jsonWritesApibuilderCommonReferenceGuid: play.api.libs.json.Writes[ReferenceGuid] = {
      new play.api.libs.json.Writes[io.apibuilder.common.v0.models.ReferenceGuid] {
        def writes(obj: io.apibuilder.common.v0.models.ReferenceGuid) = {
          jsObjectReferenceGuid(obj)
        }
      }
    }
  }
}

package io.apibuilder.common.v0 {

  object Bindables {

    import play.api.mvc.{PathBindable, QueryStringBindable}

    // import models directly for backwards compatibility with prior versions of the generator
    import Core._

    object Core {
      implicit val pathBindableDateTimeIso8601: PathBindable[_root_.org.joda.time.DateTime] = ApibuilderPathBindable(ApibuilderTypes.dateTimeIso8601)
      implicit val queryStringBindableDateTimeIso8601: QueryStringBindable[_root_.org.joda.time.DateTime] = ApibuilderQueryStringBindable(ApibuilderTypes.dateTimeIso8601)

      implicit val pathBindableDateIso8601: PathBindable[_root_.org.joda.time.LocalDate] = ApibuilderPathBindable(ApibuilderTypes.dateIso8601)
      implicit val queryStringBindableDateIso8601: QueryStringBindable[_root_.org.joda.time.LocalDate] = ApibuilderQueryStringBindable(ApibuilderTypes.dateIso8601)
    }

    trait ApibuilderTypeConverter[T] {

      def convert(value: String): T

      def convert(value: T): String

      def example: T

      def validValues: Seq[T] = Nil

      def errorMessage(key: String, value: String, ex: java.lang.Exception): String = {
        val base = s"Invalid value '$value' for parameter '$key'. "
        validValues.toList match {
          case Nil => base + "Ex: " + convert(example)
          case values => base + ". Valid values are: " + values.mkString("'", "', '", "'")
        }
      }
    }

    object ApibuilderTypes {
      import org.joda.time.{format, DateTime, LocalDate}

      val dateTimeIso8601: ApibuilderTypeConverter[DateTime] = new ApibuilderTypeConverter[DateTime] {
        override def convert(value: String): DateTime = format.ISODateTimeFormat.dateTimeParser.parseDateTime(value)
        override def convert(value: DateTime): String = format.ISODateTimeFormat.dateTime.print(value)
        override def example: DateTime = DateTime.now
      }

      val dateIso8601: ApibuilderTypeConverter[LocalDate] = new ApibuilderTypeConverter[LocalDate] {
        override def convert(value: String): LocalDate = format.ISODateTimeFormat.yearMonthDay.parseLocalDate(value)
        override def convert(value: LocalDate): String = value.toString
        override def example: LocalDate = LocalDate.now
      }

    }

    case class ApibuilderQueryStringBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends QueryStringBindable[T] {

      override def bind(key: String, params: Map[String, Seq[String]]): _root_.scala.Option[_root_.scala.Either[String, T]] = {
        params.getOrElse(key, Nil).headOption.map { v =>
          try {
            Right(
              converters.convert(v)
            )
          } catch {
            case ex: java.lang.Exception => Left(
              converters.errorMessage(key, v, ex)
            )
          }
        }
      }

      override def unbind(key: String, value: T): String = {
        converters.convert(value)
      }
    }

    case class ApibuilderPathBindable[T](
      converters: ApibuilderTypeConverter[T]
    ) extends PathBindable[T] {

      override def bind(key: String, value: String): _root_.scala.Either[String, T] = {
        try {
          Right(
            converters.convert(value)
          )
        } catch {
          case ex: java.lang.Exception => Left(
            converters.errorMessage(key, value, ex)
          )
        }
      }

      override def unbind(key: String, value: T): String = {
        converters.convert(value)
      }
    }

  }

}
