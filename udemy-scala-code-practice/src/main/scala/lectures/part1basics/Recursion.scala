package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  //STACK RECURSION
  //In this if we pass larger value then it throw Stack overflow error
  def factorial(num: Int): Int = {
    if (num == 1) num
    else num * factorial(num - 1)
  }

  println("factorial of number is :" + factorial(5))


  def recursive(num: Int): Int = {
    //TO overcome from Stack Overflow we have to use TAIL recursion
    //In TAIL recursion in same stack it perform the computation
    @tailrec
    def helper(num: Int, accumulator: Int): Int = {
      if (num <= 1) accumulator
      else helper(num - 1, num * accumulator)
    }

    helper(num, 1)
  }

  println(recursive(10))


  //PRACTICE CODE
  // 1--> Concatenate a string using tail recursion
  def concateString(name: String, num: Int, accumulator: String): String = {
    if (num <= 0) accumulator
    else concateString(name, num - 1, name.concat(accumulator))
  }

  println(concateString("Manish ", 10, ""))

  // 2-->isPrime using
  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(num / 2)
  }

  println(isPrime(30))

  //3-->Fibonacci series
  def fibonacci(n: Int): Int = {
    def fibonacciTail(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTail(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTail(2, 1, 1)
  }

  println(fibonacci(8))

}

