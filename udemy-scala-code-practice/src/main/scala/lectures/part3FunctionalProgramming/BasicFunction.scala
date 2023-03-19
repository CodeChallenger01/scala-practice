package lectures.part3FunctionalProgramming

object BasicFunction extends App {

  //HAving 22 types of Function in scala 2
  val doubler = new Function[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("45") + 21)

  //ALL SCALA FUNCTIONS ARE OBJECTS or instance of classes from Function Class

  //Exercises

  //1-->String concatenation by using Function Classes
  val stringConcate: (String, String) => String = new Function2[String, String, String] {
    override def apply(string1: String, string2: String): String = string1 + string2
  }
  println(stringConcate("Manish ", "Mishra "))

  //2->HIGHER
  val check: Int => (Int => Int) = new Function1[Int, Function1[Int, Int]] {
    override def apply(num1: Int):(Int=>Int)=new Function[Int,Int] {
      def apply(y:Int):Int=num1+y
    }
  }
  val adder=check(2)
  println(adder(2))
  println(check(4)(40))
}
