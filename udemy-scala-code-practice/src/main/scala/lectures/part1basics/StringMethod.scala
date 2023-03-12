package lectures.part1basics

object StringMethod extends App {
  val str :String="Hello, this is String variable"
  println(str)

  //Some of the Methods of String are:
  println(str.charAt(2))
  println(str.substring(2,10))
  println(str.split(" ").toList)
  println(str.startsWith("String"))
  println(str.replace(" ","+"))
  println(str.toUpperCase())
  println(str.toLowerCase())
  println(str.length)

  val aNumString:String="1849"
  val aNumber:Int=aNumString.toInt
  println(aNumber)
  println('a' +: aNumString :+ 'l')
  println(str.reverse)
  println(str.take(10))

  //String Interpolation

  //1-->s-Interpolation
  val name:String="Manish Mishra"
  val age:Int=21
  val greeting: String = s"Hi, my name is  $name and I am ${age+0}year old"
  println(greeting)

  //2-->In f String interpolation we can can handle the digit after or before the decimal
  //same as we declare in printf function %0.3f etc.
  val speed: Float = 4.522f
  val result:String=f"$name%s can drive a car with speed ${speed}%2.2f per hr"
  println(result)
  //neglect the 2 at unit place in speed

  //3-->raw interpolation
  /*
  Similar to s-interpolation but in this if we use \n then
  it print that instead to move to new line
   */
   println(raw"Hi I am Manish Mishra \n A Software Intern")
  val escaped:String="Hi I am \n Manish Mishra"
  println(raw"$escaped")
}
