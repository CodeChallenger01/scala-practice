package lectures.part3FunctionalProgramming

object MapFlatmapFilterForComprehension extends App {

  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ * 2))

  //filter
  println(list.filter(_ % 2 == 0))
  println(list.filter(_ % 2 != 0))

  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  //  Exercises
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c')
  val colors = List("Black", "White")
  val concat = numbers.flatMap(n => chars.flatMap(c => colors.map(co => "" + c + n + " " + co)))
  println(concat)

  //for comprehension
  val forCombination = for {
    n <- numbers
    c <- chars
    co <- colors
  } yield "" + c + n + " " + co
  println(forCombination)

  val doubler = for {
    l <- list if l % 2 == 0
  } yield l * l
  println(doubler)

  //Syntax overload
  val result = list.map { x =>
    x * 2
  }
  println(result)


  //EXERCISES

  //Go through it once again to know more
  abstract class MayBe[+T] {
    def map[B](f: T => B): MayBe[B]

    def flatMap[B](f: T => MayBe[B]): MayBe[B]

    def filter(p: T => Boolean): MayBe[T]
  }

  case object MayBeNot extends MayBe[Nothing] {
    override def map[B](f: Nothing => B): MayBe[B] = MayBeNot

    override def flatMap[B](f: Nothing => MayBe[B]): MayBe[B] = MayBeNot

    override def filter(p: Nothing => Boolean): MayBe[Nothing] = MayBeNot
  }

  case class Just[+T](value: T) extends MayBe[T] {
    override def map[B](f: T => B): MayBe[B] = Just(f(value))

    override def flatMap[B](f: T => MayBe[B]): MayBe[B] = f(value)

    override def filter(p: T => Boolean): MayBe[T] = {
      if (p(value)) this
      else MayBeNot
    }
  }

  val just3 = Just[Int](3)
  println(just3)
  println(just3.map(_ * 3))
  println(just3.flatMap((x => Just(x % 2 == 0))))
  println(just3.filter(_ % 2 == 0))
}
