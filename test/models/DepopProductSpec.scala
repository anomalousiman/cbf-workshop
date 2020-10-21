package models

import org.scalatest.wordspec.AnyWordSpec
import play.api.libs.json.Json

class DepopProductSpec extends AnyWordSpec {

  "DepopProduct" should {
    "serialise correctly to json" in {
      val product = DepopProduct(
        0,
        "Shirt",
        "A Shirt, a black T shirt.",
        List(
          "https://lp.weekday.com/app003prod?set=source[02_0410605_001_001],type[PRODUCT],device[hdpi],quality[80],ImageVersion[2]&call=url[file:/product/main]")
      )
      val expectedJson =
        """
                      {
                   |      "id": 0,
                   |      "name": "Shirt",
                   |      "description": "A Shirt, a black T shirt.",
                   |      "images": [
                   |        "https://lp.weekday.com/app003prod?set=source[02_0410605_001_001],type[PRODUCT],device[hdpi],quality[80],ImageVersion[2]&call=url[file:/product/main]"
                   |      ]
                   |   }""".stripMargin

      println(Json.toJson(product))

      assert(Json.toJson(product) === Json.parse(expectedJson))

    }
  }

}
