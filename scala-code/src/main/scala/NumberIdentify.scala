import scala.io.StdIn.readLine

class NumberIdentify {
  private def identify(input: String): Int = {
    for (i <- 0 until input.length) {
      if (input.charAt(i).isDigit) {
        return 0
      }
    }
    return 1
  }
}
object NumberIdentify extends App{
  val input:String=readLine("Enter the String")
  val obj=new NumberIdentify
  private val res:Int=obj.identify(input)
  if(res==0){
    print("String Contains Digit")
  }
  else{
    print("It is String")
  }
}
