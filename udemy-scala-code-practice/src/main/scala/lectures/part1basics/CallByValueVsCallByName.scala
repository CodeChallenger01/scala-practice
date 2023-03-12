package lectures.part1basics

object CallByValueVsCallByName extends App {

  /*
  It is CALL BY VALUE FUNCTION
  the parameter of the below function use only semicolon
  In Call By Value it compute only one time after that provide the same input
  */
  def printNum(num: Int): Unit = {
    println(num)
    println(num)
    println(num)
  }

  println("Call by Value Output")
  var count: Int = 0
  printNum {
    count += 1
    count
  }

  /*
  It is CALL BY NAME Function
  Inside the parameter we have to use => sign for call by name
  It Compute every time when it needs.
  */
  def printNumAgain(num1: => Int): Unit = {
    println(num1)
    println(num1)
    println(num1)
  }

  println("Call by Name Output")
  var countAgain: Int = 0
  printNumAgain {
    countAgain += 1
    countAgain
  }
}
