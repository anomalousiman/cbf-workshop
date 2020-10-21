package exercises

import models._
import org.scalatest.wordspec.AnyWordSpec

// Test suite for the functions we'll be writing as exercises

// To run an individual test or group of tests, right click inside the test and press 'Run ...'

class ExerciseSpec extends AnyWordSpec {
  val productId1 = 1
  val productId2 = 2
  val someImages: List[String] = List("image1.jpg", "image2.jpg", "image3.jpg")
  val product1 =
    DepopProduct(productId1, "a product", "a product description", someImages)
  val product2 = DepopProduct(productId2,
                              "another product",
                              "another product description",
                              someImages)
  val testProducts: List[DepopProduct] = List(product1, product2)
  val likes: List[Like] = List(Like(productId1), Like(productId2))

  "Exercise 1 - Lists" should {

    "getProduct" should {

      "return a list containing products with matching ids" in {
        assert(
          Exercise1.getProduct(productId1, testProducts) === List(product1))
      }

      "return an empty list when the product is not found" in {
        val someProductId = 3
        assert(Exercise1.getProduct(someProductId, testProducts) === Nil)
      }
    }

    "getLikedProductIds" should {

      "take a list of Likes and return a list of product ids" in {
        assert(
          Exercise1.getLikedProductIds(likes) === List(productId1, productId2))
      }
    }

    "stretch - getImages" should {
      "get the images from a list of images" in {
        assert(
          Exercise1.getImages(testProducts) === List("image1.jpg",
                                                     "image2.jpg",
                                                     "image3.jpg",
                                                     "image1.jpg",
                                                     "image2.jpg",
                                                     "image3.jpg"))
      }

    }
  }

  "Exercise 2 - Options" should {

    "stringToInt" should {
      "return an Option of a string if the string can be converted to an Int" in {
        assert(Exercise2.stringToInt("3") === Some(3))
      }

      "return None if the string can't be converted to an Int" in {
        assert(Exercise2.stringToInt("bananas") === None)
      }
    }

    "getProductIdWithImages" should {

      val productWithImages = DepopProduct(0, "with description", "", List("Img1"))
      val productWithoutImages = DepopProduct(0, "with description", "", Nil)

      "return the product ID of the product if product has images" in {
        assert(
          Exercise2.getProductIdWithImages(productWithImages) === Some(productWithImages).map(_.id)
        )
      }

      "return None if the product has no images" in {
        assert(
          Exercise2.getProductIdWithImages(productWithoutImages) === None
        )
      }
    }
  }

  "Exercise 3 - Pattern Matching" should {

    "headOption" should {
      "return Some of the first element in the list if it is nonempty" in {
        assert(Exercise3.headOption(testProducts) === Some(product1))
      }

      "return None if the list is empty" in {
        assert(Exercise3.headOption(Nil) === None)
      }
    }

    "wasOperationSuccessful" should {

      "return true if the operation was successful" in {
        assert(Exercise3.wasOperationSuccessful(OperationSuccess) === true)
      }

      "return false if the operation failed" in {
        assert(Exercise3.wasOperationSuccessful(OperationFailure) === false)
      }

      "return false if the operation result is unknown" in {
        assert(Exercise3.wasOperationSuccessful(UnknownResult) === false)
      }
    }

    "stretch - getTShirt" should {
      "return the product's id if the product name is t-shirt" in {
        assert(
          Exercise3.getTShirt(Some(
            DepopProduct(1, "t-shirt", "description", someImages))) === Some(1))
      }

      "return None if the product name is not t-shirt" in {
        assert(
          Exercise3.getTShirt(
            Some(
              DepopProduct(1,
                           "jeans",
                           "description",
                           someImages))) === None)
      }

      "return None if the argument is None" in {
        assert(Exercise3.getTShirt(None) === None)
      }
    }
  }

  "Exercise 4 - Recursion" should {

    "sum" should {

      "the sum of an empty list is 0" in {
        assert(Exercise4.sum(Nil) === 0)
      }

      "the sum of a single number is that number itself" in {
        assert(Exercise4.sum(List(8)) === 8)
      }

      "the sum of a list of numbers is their sum" in {
        assert(Exercise4.sum(List(1, 2, 3, 4)) === 10)
      }
    }
    "product" should {

      "the product of an empty list is 1" in {
        assert(Exercise4.product(Nil) === 1)
      }

      "the product of a single number is that number itself" in {
        assert(Exercise4.product(List(8)) === 8)
      }

      "the sum of a list of numbers is their product" in {
        assert(Exercise4.product(List(1, 2, 3, 4)) === 24)
      }
    }

    "take" should {

      "return Nil for n=0" in {
        assert(Exercise4.take(List(4, 5, 8), 0) === Nil)
      }

      "return the first element for n=1" in {
        assert(Exercise4.take(List(3, 4), 1) === List(3))
      }

      "take n elements if available" in {
        assert(Exercise4.take(List(1, 2, 3, 4, 5, 6), 3) === List(1, 2, 3))
      }

      "all elements if n >= count" in {
        assert(Exercise4.take(List(1, 2, 3, 4, 5, 6), 8) === List(1, 2, 3, 4, 5, 6))
      }
    }

    "dropWhile" should {

      "return Nil for Nil" in {
        assert(Exercise4.dropWhile[Nothing](Nil)( _ => true) === Nil)
      }

      "drop until the first hit" in {
        assert(Exercise4.dropWhile(List(1, 2, 3, 4, 5, 4, 3, 2, 1))( _ < 3) === List(3, 4, 5, 4, 3, 2, 1))
      }
    }

    "foldSum" should {

      "the sum of an empty list is 0" in {
        assert(Exercise4.foldSum(Nil) === 0)
      }

      "the sum of a single number is that number itself" in {
        assert(Exercise4.foldSum(List(8)) === 8)
      }

      "the sum of a list of numbers is their sum" in {
        assert(Exercise4.foldSum(List(1, 2, 3, 4)) === 10)
      }
    }

    "foldProduct" should {

      "the product of an empty list is 1" in {
        assert(Exercise4.foldProduct(Nil) === 1)
      }

      "the product of a single number is that number itself" in {
        assert(Exercise4.foldProduct(List(8)) === 8)
      }

      "the product of a list of numbers is their product" in {
        assert(Exercise4.foldProduct(List(1, 2, 3, 4)) === 24)
      }
    }

  }

}
