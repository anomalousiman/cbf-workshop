package exercises

import exercises.Examples.steve
import models.DepopProduct

object Exercise2 {

  // Part 1

  // We can create an option value by simply wrapping the value in Some() because Some is a case class
  val numberOneOption: Option[Int] = Some(1)

  val steveOption: Option[Person] = Some(steve)

  // We can return an Option when an operation might fail - it's impossible to take the square root of a negative number,
  // so we return None if a negative number is given
  def squareRoot(number: Double): Option[Double] = {
    if (number >= 0)
      Some(math.sqrt(number))
    else None
  }

  def unsafeDivision(divide: Double, by: Double): Double =
    divide / by

  // Division by zero is not defined, capture this using Option
  def safeDivision(divide: Double, by: Double): Option[Double] =
    ???

  // Part 2

  // We can write a function that gets the name of an Option[Person] by using map
  // If we have an Option[Person] we can use map to do computations as if we had a Person
  val maybeStevesName = steveOption
    .map(person => person.name)

  // and filter like we did with lists
  // If the predicate does not hold for the value this results in None
  // If there was no value (None), this also results in None
  def hasMiddleName(name: String): Boolean =
    name.contains(" ")
  val withMiddleName = maybeStevesName
    .filter(hasMiddleName)

  // Find the id of the product only if there is a description
  // hint: A list has the method .nonEmpty to check if it is not empty
  def getProductIdWithImages(product: DepopProduct): Option[Int] = {
    val productWithDescription: Option[DepopProduct] = ???

    ???
  }

  // Stretch exercise

  // Try and parse a string into an Int
  def stringToInt(string: String) =
    try {
      Integer.parseInt(string.trim)
    } catch {
      case _: NumberFormatException => null
    }

}
