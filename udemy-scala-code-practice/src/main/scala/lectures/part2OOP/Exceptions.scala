package lectures.part2OOP

object Exceptions extends App {
  val name: String = null

  //When above field is accessed it throw exception
  //if we did n't handle it
  //to throw exception
  /*
  val ex: String=throw new NullPointerException
*/
  def getInt(isTrue: Boolean): Int =
    if (isTrue) throw new RuntimeException("No int for you")
    else 42

  try {
    //Code that might exception
    getInt(true)
  }
  catch {
    case e: RuntimeException => println("Exception")
  }
  finally {
    println("Finally Executed")
  }

  //Define OWN Exception
  class MyException extends Exception

  val exception = new MyException
  //  throw exception-->to throw exceptions


  //Exercises
  //1-->crash program by OUT OF MEMORY
  /*
  val array = Array.ofDim(Int.MaxValue)
   */

  //2--> Stack overflow
  /*
  def count:Int=1+count
  val value=count
  */


  //3-->Catch error
  class OverFlowException extends Exception

  class UnderFlowException extends Exception

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def sub(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

  }
  val obj=PocketCalculator
  println(obj.add(100, 200))
//  println(obj.add(Int.MaxValue, Int.MaxValue))//throw the exception
  println(obj.sub(-100, 2))
}
