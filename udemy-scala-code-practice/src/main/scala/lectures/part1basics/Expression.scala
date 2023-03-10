package lectures.part1basics

object Expression extends App {
  //An Expression is series of values, variables that return something or compute thr result

  val add: Int = 1 + 2 + 3
  val sub: Int = 10 - 2
  println(add + " " + sub)
  //Some more arithmetic operator are +,-./,*,%

  val isString: Boolean = true
  val aConditionValue: Int = if (isString) 1 else 0 //IF Expression
  println(aConditionValue)


  //Code Block is expression
  //Type of code block variable depend upon the last expression
  //variable scope inside the block only of code block variable
  val result = {
    val aNum: Int = 20
    val aSecondNum: Int = 40
    if (aNum > aSecondNum) "true" else "false"
  }
  print(result)
}
