package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class StatusController @Inject()(implicit ec: ExecutionContext)
    extends InjectedController {

  def status: Action[AnyContent] = Action.async { _ =>
    Future(Ok(Json.toJson(Map("status" -> "OK"))))
  }

}
