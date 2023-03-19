package lectures.part3FunctionalProgramming

object HigherOrderFunctionCurries extends App {

  //Higher Order Function
  //Example: Map, flatMap, filter

  def nTimes(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimes(f, n - 1)(f(x))

  val plusOne = (x: Int) => x + 1
  val plus10 = nTimes(plusOne, 10)
  println(plus10(1))

  //VERIFY   IT
  //  val check: Int => (Int => Int) = new Function1[Int, Function1[Int, Int]] {
  //    override def apply(num1: Int): (Int => Int) = new Function[Int, Int] {
  //      def apply(y: Int): Int = num1 + y
  //    }
  //  }
  //  println(check(4)(40))

  //    Curried Function
  val superAdd: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  println(superAdd(2)(5))

  //Function with multiple parameter
  def curriedFunction(c: String)(x: Double): String = c.format(x)

  val standarFormat: (Double => String) = curriedFunction(("%4.2f"))
  val preciseFormat: (Double => String) = curriedFunction(("%10.8f"))
  println(standarFormat(Math.PI))
  println(preciseFormat(Math.PI))
  println(curriedFunction("%4.9f")(Math.PI))

  /*
  * Exercise
  */


  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  def andThen(f: Int => Int, g: Int => Int): Int => Int =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)

  def add4 = superAdder2(4)

  println(add4(10))

  val add2=(x:Int)=>x+2
  val times3=(x:Int)=>x*3
  val composed=compose(add2,times3)
  val ordered=andThen(add2,times3)
  println(composed(4))
  println(ordered(4))
}
