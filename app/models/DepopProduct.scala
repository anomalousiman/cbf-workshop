package models

import play.api.libs.json.{Json, OFormat}

case class DepopProduct(id: Int,
                        name: String,
                        description: String,
                        images: List[String])

object DepopProduct {
  implicit val format: OFormat[DepopProduct] = Json.format[DepopProduct]
}
