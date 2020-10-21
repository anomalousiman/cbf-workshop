package exercises

import models.{
  DepopProduct,
  OperationFailure,
  OperationResult,
  OperationSuccess,
  UnknownResult
}

object Exercise3 {

  // We can pattern match on the contents of a list

  // :: breaks a list down into its head and tail
  // For example, List(1,2,3) = 1 :: List(2,3)

  def checkNumbers(list: List[Int]): String = list match {
    case Nil =>
      "The list is empty" // Nil is an object which represents the empty List
    case _ :: Nil =>
      "There is one number in the list" // This will match on any List with one element
    case 1 :: List(2, 3) =>
      "The list is 1,2,3" // This will only match on List(1,2,3)
    case 1 :: _ =>
      "The first number in the list is 1" // This will only match on a List with 1 at its head
    case someNumber :: _ =>
      s"The first number in the list is: $someNumber" // This will match on any non-empty List
  }

  // We can pattern match on the type of a variable as well as its value
  def favouriteFruit(fruit: Fruit): Boolean = fruit match {
    case Bananas => false
    case Apples  => false
    case Oranges => true
  }

  // Optionally return the first product in the list
  def headOption(list: List[DepopProduct]): Option[DepopProduct] = ???

  // Use pattern matching to check the success of an operation
  def wasOperationSuccessful(operationResult: OperationResult): Boolean = ???

  // Stretch exercise:
  // Given an option of a product, if the product's name is "t-shirt" then return its ID, otherwise return None
  // hint: We can pattern match on options and the values inside a case class
  def getTShirt(maybeProduct: Option[DepopProduct]): Option[Int] = ???

}
