package models

import scala.concurrent.Future

trait ProductDao {

  def getAllProducts: Future[List[DepopProduct]]

  def getProductDetails(productId: Int): Future[Option[DepopProduct]]

  def like(productId: Int): Future[OperationResult]

  def unlike(productId: Int): Future[OperationResult]

  def getAllLikes: Future[List[Like]]
}
