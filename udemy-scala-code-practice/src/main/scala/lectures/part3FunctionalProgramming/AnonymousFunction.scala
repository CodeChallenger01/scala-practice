package lectures.part3FunctionalProgramming

object AnonymousFunction extends App {
  //Function By using Function Class
  val doublerbasic: Int => Int = new Function[Int, Int] {
    def apply(num: Int): Int = num * num
  }
  println(doublerbasic(2))

  //Function by Using Anonymous Function(LAMBDA)
  val doubler: (Int => Int) = (num: Int) => num * num
  println(doubler(2))

  //Function by Using Anonymous Function
  val doublerOther = (num: Int) => num * num //syntactic sugar
  println(doublerOther(3))

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b
  println(adder(40, 21))

  //Without no parameter
  val doSomething: () => Int = () => 3
  println(doSomething) //Print function itself
  println(doSomething()) //print the output

  //curly braces with lambda
  val strignToInt: String => Int = {
    str: String => str.toInt
  }
  println(strignToInt("456"))

  //More syntactic Sugar
  val increment: Int => Int = _ + 1 //equivalent to x=>x+1
  println(increment(10))

  val niceAdder: (Int, Int) => Int = _ + _ //Euivalent to (a,b)=>a+b
  println(niceAdder(10, 20))


  //Exercise
  val superAdd: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  println(superAdd(2)(5))

}
