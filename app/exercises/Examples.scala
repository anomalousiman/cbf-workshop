package exercises

import scala.annotation.tailrec

case class Person(name: String, id: Int) // This represents our record of a Person, containing data about them

sealed trait Fruit
object Bananas extends Fruit
object Oranges extends Fruit
object Apples extends Fruit

object Examples {

  // DECLARING VARIABLES AND TYPES

  val helloString
    : String = "hello" // Creates an immutable variable called helloString, of type String

  val steve: Person = Person("Steve", 1) // We can create an instance of a Person like this

  val steveId
    : Int = steve.id // We use . notation to access parameters of the case class

  // List is a class which must be given a type parameter
  // A List[Int] can only contain values of type Int
  val myList: List[Int] = List(1, 2, 3)

  val personList: List[Person] = List(steve)

  // FUNCTIONS

  // When we define functions we define the input variable names and their types, and the return type
  def multiplyNumbers(x: Int, y: Int): Int = x * y

  // If the function needs to go over multiple lines, wrap it in curly brackets
  def addNumbers(x: Int, y: Int): Int = {
    val sum: Int = x + y
    sum // No need for the return keyword, the last expression is taken as the return value
  }

  // RECURSION

  // This function will recursively go through the list and print each number in it
  def printNumbers(numbers: List[Int]): Unit = {

    @tailrec
    def helper(remainingNumbers: List[Int]): Unit = remainingNumbers match {
      case Nil =>
        println("finished") // there is nothing left in the list, so we don't call the helper again
      case head :: tail =>
        println(head) // print the number at the head of the list
        helper(tail) // call the helper function again with the rest of the list
    }

    helper(numbers)
  }

}
