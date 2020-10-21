package exercises

import models.{DepopProduct, Like}

object Exercise1 {

  // This function takes a List of Person and returns a List of Int
  def getPersonId(people: List[Person]): List[Int] = {
    people.map(person => person.id) // This is anonymous function - it doesn't need a name or types
  }

  // This function takes a name and a list of people, and filters it so it only contains people with that name
  def filterPeople(name: String, people: List[Person]): List[Person] = {
    people.filter(person => person.name == name)
  }

  // Filter a list of products by product ID
  def getProduct(productId: Int,
                 products: List[DepopProduct]): List[DepopProduct] = ???

  // Transform a list of Likes into a list of product IDs (Ints)
  def getLikedProductIds(likes: List[Like]): List[Int] = ???

  // Stretch Exercise: Look up the definition of the flatMap method and use it to get
  // the images from a list of products, and return a list of image urls
  def getImages(products: List[DepopProduct]): List[String] = ???

}
