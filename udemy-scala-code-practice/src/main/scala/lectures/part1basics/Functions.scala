package lectures.part1basics

object Functions extends App {

  //to define function in scala by using -->def
  def simpleFunction(a: String, b: String): String = {
    a + " " + b
  }

  println(simpleFunction("Manish", "Mishra"))

  //Function with recursion
  //In recursive function it is necessary to define the output type of function
  def recursionFunction(aString: String, b: Int): String = {
    if (b == 1) aString
    else aString + " " + recursionFunction(aString, b - 1)
  }

  println("Using Recursion \n" + recursionFunction("Manish", 3))


  //AUXILIARY FUNCTION
  //Those function which helps other function to perform the task
  def aFunction(n: Int): Int = {
    def auxiliaryFunction(a: Int, b: Int): Int = {
      a + b
    }

    auxiliaryFunction(3, n - 1)
  }

  println(aFunction(4))

  //PRACTICE CODE
  //  1-->Greeting Function
  def greeting(name: String, age: Int): String = {
    "Hi My Name is " + name + ". I am " + age + " year old"
  }

  println(greeting("Manish", 21))

  //  2--> Factorial Function
  def factorial(num: Int): Int = {
    if (num == 1) num
    else num * factorial(num - 1)
  }

  println("factorial of number is :" + factorial(5))


  // 3-->Fibonacci Series
  def fibonacci(num: Int): Int = {
    if (num <= 1) num
    else fibonacci(num - 1) + fibonacci(num - 2)
  }

  println("Fibonacci Series is :\n" + fibonacci(2))


  // 4-->Number is prime or not
  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else num % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(num / 2)
  }

  print(isPrime(30))
}





