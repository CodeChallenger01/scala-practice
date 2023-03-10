package lectures.part1basics

object ValuesVariablesTypes extends App {
  //Different types of variables

  //  1-->Immutable Variable-->It throw error while re-assignment the variable
  //define by using --val--
  val aNum: Int = 42
  val aString: String = "Manish Mishra"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val aShort: Short = 10244
  val aLong: Long = 2222
  val aFloat: Float = 3.222f // f is necessary to use float value
  val aDouble: Double = 3.14
  print(aNum + " " + aString + " " + aBoolean + " " + aChar + " " + aShort + " " + aLong + " " + aFloat + " " + aDouble)


  // 2--> Mutable Variable --> It Doesn't throw error while reassignment of the variable
  //defined by using --var-- & it also comes under side effects

  var aSecondNum: Int = 42
  aSecondNum = 100 //side effect
  print(aSecondNum)
}
