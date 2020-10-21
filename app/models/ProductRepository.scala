package models

import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for products.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class ProductRepository @Inject()(dbConfigProvider: DatabaseConfigProvider)(
    implicit ec: ExecutionContext)
    extends ProductDao {
  // We want the JdbcProfile for this provider
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table containing our products
    */
  private class ProductTable(tag: Tag)
      extends Table[DepopProduct](tag, "products") {

    /** The ID column, which is the primary key */
    def id = column[Int]("id", O.PrimaryKey)

    /** The name column */
    def name = column[String]("name")

    /** The description column */
    def description = column[String]("description")

    implicit val listOfStringType: BaseColumnType[List[String]] =
      MappedColumnType.base[List[String], String](
        list => list.mkString("|"),
        string => string.split('|').toList)

    /** The image column */
    def images = column[List[String]]("images")

    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Product object.
      *
      * In this case, we are simply passing the id, name, description and image parameters to the Product case classes
      * apply and unapply methods.
      */
    def * =
      (id, name, description, images) <> ((DepopProduct.apply _).tupled, DepopProduct.unapply)
  }

  /**
    * The starting point for all queries on the product table.
    */
  private val products = TableQuery[ProductTable]

  /**
    * List all the products in the database.
    */
  def getAllProducts: Future[List[DepopProduct]] =
    db.run {
        products.result
      }
      .map(_.toList)

  /**
    * Get the details for one product.
    */
  def getProductDetails(productId: Int): Future[Option[DepopProduct]] = db.run {
    products.filter(_.id === productId).result.headOption
  }

  /**
    * Here we define the table containing our likes
    */
  private class LikesTable(tag: Tag) extends Table[Like](tag, "likes") {

    /** The product id column, which is the primary key */
    def productId: Rep[Int] = column[Int]("product_id", O.PrimaryKey)

    def * = productId <> (Like.apply, Like.unapply)
  }

  /**
    * The starting point for all queries on the likes table.
    */
  private val likes = TableQuery[LikesTable]

  /**
    * Like a product
    */
  def like(productId: Int): Future[OperationResult] = {
    val affectedRows = db.run {
      likes.insertOrUpdate(Like(productId))
    }
    affectedRows.map {
      case 0 => OperationFailure
      case 1 => OperationSuccess
      case _ => UnknownResult
    }
  }

  /**
    * Unlike a product
    */
  def unlike(productId: Int): Future[OperationResult] = {
    val affectedRows: Future[Int] = db.run {
      likes.filter(_.productId === productId).delete
    }
    affectedRows.map { numRows =>
      if (numRows == 1) OperationSuccess else OperationFailure
    }
  }

  /**
    * Get all the products we like
    */
  def getAllLikes: Future[List[Like]] =
    db.run {
        likes.result
      }
      .map(_.toList)
}
