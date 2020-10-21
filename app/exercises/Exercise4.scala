package exercises

object Exercise4 {

  // Part 1

  def count(xs: List[Int]): Int =
    xs match {
      case Nil => 0
      case head :: tail => 1 + count(tail)
    }

  def sum(xs: List[Int]): Int =
    xs match {
      case Nil => 0
      case head :: tail => ???
    }

  def product(xs: List[Int]): Int =
    ???

  // Part 2

  def drop[T](xs: List[T], n: Int): List[T] =
    if (n < 1) xs
    else xs match {
      case _ :: tail => drop(tail, n - 1)
      case Nil => Nil
    }

  def take[T](xs: List[T], n: Int): List[T] =
    if (n < 1) Nil
    else xs match {
      case head :: tail => ???
      case Nil => Nil
    }

  // Stretch exercises!
  
  def takeWhile[T](xs: List[T])(p: T => Boolean): List[T] =
    xs match {
      case head :: tail if (p(head)) => head :: takeWhile(tail)(p)
      case _ :: _ => Nil
      case Nil => Nil
    }

  def dropWhile[T](xs: List[T])(p: T => Boolean): List[T] =
    ???

  def fold[In, Out](in: List[In], base: Out)(f: (In, Out) => Out): Out =
    in match {
      case Nil => base
      case head :: tail => f(head, fold(tail, base)(f))
    }

  def foldCount(xs: List[Int]): Int =
    fold(xs, 0) {
      (element, combined) => 1 + combined
    }

  def foldSum(xs: List[Int]): Int =
    fold[Int, Int](xs, ???) { (element, combined) => ??? }

  def foldProduct(xs: List[Int]): Int =
    ???
}
