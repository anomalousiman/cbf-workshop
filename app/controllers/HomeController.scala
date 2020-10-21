package controllers
import javax.inject.Inject
import models.ProductDao
import play.api.libs.json.Json
import play.api.mvc._
import exercises._

import scala.concurrent.ExecutionContext

class HomeController @Inject()(productDao: ProductDao)(
    implicit ec: ExecutionContext)
    extends InjectedController {

  def productDetails(productId: Int): Action[AnyContent] = Action.async {
    implicit request =>
      productDao.getAllProducts.map { products =>
        Exercise3.headOption(Exercise1.getProduct(productId, products)) match {
          case Some(product) => Ok(Json.toJson(product))
          case None          => NotFound
        }
      }
  }

  def getAllProducts: Action[AnyContent] = Action.async { implicit request =>
    productDao.getAllProducts.map { products =>
      Ok(Json.toJson(products))
    }
  }

  def getLikes: Action[AnyContent] = Action.async { implicit request =>
    productDao.getAllLikes.map { likes =>
      Ok(Json.toJson(Exercise1.getLikedProductIds(likes)))
    }
  }

  def like(productId: Int): Action[AnyContent] = Action.async {
    implicit request =>
      productDao.like(productId).map { result =>
        if (Exercise3.wasOperationSuccessful(result)) Ok
        else InternalServerError
      }
  }

  def unlike(productId: Int): Action[AnyContent] = Action.async {
    implicit request =>
      productDao.unlike(productId).map { result =>
        if (Exercise3.wasOperationSuccessful(result)) Ok
        else InternalServerError
      }
  }

}
