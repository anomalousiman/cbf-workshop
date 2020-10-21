# Depop Scala Workshop

Scala setup instructions are at [https://www.scala-lang.org/download/]


## Running the project


Run the project using
```
sbt run
```

Then go to [http://localhost:9009/] to see the application.

## Run the tests

Run all the tests using
```
sbt test
```


## Exercises

Exercises are in the `exercises/` folder

Tests are in a file called `ExerciseSpec.scala`

Check out the examples in `Examples.scala` if you get stuck!

### Exercise 1 - Lists

A List in scala is an immutable sequence of elements. Each element must be of the same type.

The map method on a List takes a function and applies it to every element in the list.

```scala
scala> List(1,2,3).map(x => x * 2)
res0: List[Int] = List(2, 4, 6)
```

The filter method on a  List takes a predicate, and returns only the elements in  the list which satisfy the predicate.
```scala
scala> List(4,5,6).filter(x => x < 5)
res1: List[Int] = List(4)
```


#### Part 1
`getProduct` is a function which accepts a product ID and a list of products, and filters the list down to only products with a matching ID.

```scala
def getProduct(productId: Int, products: List[DepopProduct]): List[DepopProduct] = ???
```
Implement the `getProduct` function.


#### Part 2
`getLikedProductIds` is a function which accepts a list of `Like` and returns a list of `Int`.
```scala
def getLikedProductIds(likes: List[Like]): List[Int] = ???
```

Recall the  definition of `Like`:
```scala
case class Like(productId: Int)
```
And that a map works by applying a function to every element in a List.
```scala
def map[B](f: A => B): List[B]
```

Implement the `getLikedProductIds` function to map a `List[Like]` into a `List[Int]`.


### Exercise 2 - Options

Option in Scala is a container for a value of a given type, with a notion of emptiness or failure. When an Option contains a value, it looks like `Some(value)` and when it is empty it is represented by the object `None`.

For example, when we get from a `Map` (like a dictionary containing key/value pairs),  if the key isn’t in the dictionary we get `None`.
```scala
scala> val dict = Map("banana" -> "fruit", "carrot" -> "vegetable")
dict: scala.collection.immutable.Map[String,String] = Map(banana -> fruit, carrot -> vegetable)

scala> dict.get("chips")
res3: Option[String] = None

scala> dict.get("banana")
res4: Option[String] = Some(fruit)
```

We can use the `map` method on Options in the same way that we use it on Lists - if the Option contains a value, `map` will apply the given function to that value or otherwise leave it as `None`
```scala
scala> Some(2).map(x => x * 2)
res5: Option[Int] = Some(4)
scala> (None: Option[Int]).map(x => x * 2)
res7: Option[Int] = None
```

#### Part 1
Implement the function `safeDivision` so that it returns `None` when trying to divide by zero.

#### Part 2

Implement the `getProductIdWithImages` function - if the product has images, it should return `Some()` of its ID, otherwise it should return None.
```scala
def getProductIdWithImages(product: DepopProduct): Option[Int] = {
    val productWithDescription: Option[Product] = ???

    ???
  }
```
Remember that `Option[]` is just a container, and so like a `List` and we can map and filter over it.

#### Stretch exercise
Refactor the `stringToInt` function so that it returns an `Option[Int]` and doesn't throw an error if the string can't be converted into a number.

### Exercise 3 - Pattern Matching

Pattern matching is a bit like a switch statement, we check a value against a pattern and behave differently depending on what we find.
```scala
scala> val x: Int = Random.nextInt(10)
x: Int = 7

scala> x match {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}
res9: String = other
```
We can also match on Lists.

```scala
scala> List(1,2,3) match {
    case Nil => "The list is empty"
    case 1 :: someOtherElements => s"This list starts with one, the rest is $someOtherElements"
    case 2 :: _ => "This list starts with 2"
    case _ => "This list starts with something else"
    } 
res15: String = This list starts with one, the rest is List(2, 3)
```

We can define our own union types and pattern match on them. A union type is like a collection of Types.
If we use a `sealed trait` in scala then it allows the compiler to let us know if we forgot to match on one of our type possibilities.

```scala
sealed trait Fruit
class Banana extends Fruit
class Apple extends Fruit
class Orange extends Fruit

def fruitString(fruit: Fruit): String = fruit match {
    case b: Banana => "bananas"
    case o: Orange => "oranges"
    }
                                               ^
       warning: match may not be exhaustive.
       It would fail on the following inputs: Apple()

```

#### Part 1
Use pattern matching to implement the `headOption` function.

`headOption` is a function which takes a List, and returns an Option, which will be `None` or `Some[A]` depending on whether the list is empty or not.
```scala
def headOption[A](list: List[A]): Option[A] = ???
```

#### Part 2

Implement the `wasOperationSuccessful` function to return `true` if the  `OperationResult` is `OperationSuccess` and false otherwise.
```scala
def wasOperationSuccessful(operationResult: OperationResult): Boolean = ???
```


### Exercise 4 - Recursion

Recursive functions are a way of splitting a problem into smaller problems that are easier to solve without using mutable state.
For example handling one element of a collection at a time.

#### Part 1

Fill in the missing part in for `sum`
```scala
def sum(xs: List[Int]): Int =
  xs match {
    case Nil => 0
    case head :: tail => ???
  }
```

Implement the `product` function to return the product of the list and 1 for an empty list. 

```scala
def product(xs: List[Int]): Int =
  ???
```

#### Part 2
There are other ways that a problem can become smaller.
An example can be seen in `drop`, here the amount of elements to drop gets smaller every step until it reaches 0.

Fill in the missing part in the function `take` to take the first `n` elements of a list.

And sometimes the stop condition is different than reaching the end of the list.
In `takeWhile` the recursion is cut short when a predicate no longer holds.

Implement the function `dropWhile` to drop elements so long a predicate `p` holds.

#### Stretch exercises!
You may have noticed a pattern, there are some reoccurring elements, in recursive functions.
1. A value for the empty list
2. A computation per element
3. A way of combining the computed values

This pattern is captured in the function `fold`.
Combining the computed values can be thought of as folding the result into itself.

Fill in the missing part in `foldSum`, the behaviour should be the same as `sum`.

Implement the function `foldProduct`, the behaviour should be the same as `product`.