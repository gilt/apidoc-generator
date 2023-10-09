package generator.elm

import io.apibuilder.spec.v0.models.{Enum, EnumValue}

object ElmEnum {
  private[this] val Unknown = "unknown"

  // "type MemberStatus = MemberStatusPending | MemberStatusActive | MemberStatusInactive | MemberStatusUnknown"
  def generate(e: Enum): String = {
    Seq(
      s"type ${Names.pascalCase(e.name)} = " + values(e).mkString(" | "),
      genToString(e)
    ).mkString("\n\n")
  }

  private[this] def values(e: Enum): Seq[String] = {
    (e.values.map(_.name) ++ Seq(Unknown)).map { name =>
      valueElmName(e, name)
    }
  }

  private[this] def valueElmName(e: Enum, value: EnumValue): String = {
    valueElmName(e, value.name)
  }

  private[this] def valueElmName(e: Enum, value: String): String = {
    Names.pascalCase(e.name + "_" + value)
  }


  /*
  memberStatusToString : MemberStatus -> String
  memberStatusToString typ =
      case typ of
          MemberStatusPending ->
              "pending"

          MemberStatusActive ->
              "active"

          MemberStatusInactive ->
              "inactive"

          MemberStatusUnknown ->
              "unknown"
   */
  private[this] def genToString(e: Enum): String = {
    def singleValue(name: String, value: String) = {
      Seq(
        s"${Names.maybeQuote(name)} ->",
        s"    ${Names.wrapInQuotes(value)}",
      ).mkString("\n").indent(8)
    }
    Seq(
      s"${Names.camelCase(e.name)}ToString : ${Names.pascalCase(e.name)} -> String",
      s"${Names.camelCase(e.name)}ToString instance =",
      "    case instance of",
      (e.values.map { v =>
        singleValue(
          name = valueElmName(e, v),
          value = v.value.getOrElse(v.name)
        )
      } ++ Seq(
        singleValue(
          name = valueElmName(e, Unknown),
          value = Unknown
        )
      )).mkString("\n")
    ).mkString("\n")
  }

  /*
  memberStatusEncoder : MemberStatus -> Encode.Value
  memberStatusEncoder type_ =
      Encode.string (memberStatusToString type_)

  memberStatusDecoder : Decoder MemberStatus
  memberStatusDecoder =
      Decode.map memberStatusFromString string

  memberStatusFromString : String -> MemberStatus
  memberStatusFromString value =
      if (value == "active") then
          MemberStatusActive
      else if (value == "pending") then
          MemberStatusPending
      else if (value == "inactive") then
          MemberStatusInactive
      else
          MemberStatusUnknown
   */
}
