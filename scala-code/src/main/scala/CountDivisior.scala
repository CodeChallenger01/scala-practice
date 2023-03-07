import scala.io.StdIn.readInt

class Count{
  def countDivisor(firstNum: Int, secondNum: Int, thirdNum: Int): Int={
    var count:Int=0
    for(index<-firstNum to secondNum){
      if(index%thirdNum==0){
        count+=1
      }
    }
    return count
  }
}

object DivisorCount extends App{
  val obj=new Count
  private val firstNum:Int = readInt()
  private val secondNum=readInt()
  private val thirdNum=readInt()
    try{
      if(thirdNum==0){
          throw new ArithmeticException
      }
      else{
        val count: Int = obj.countDivisor(firstNum, secondNum, thirdNum)
        print("Total Count :" + count)
      }
    }
    catch{
      case ex:ArithmeticException =>{
        print(" Divide by Zero Exception [Divisor Cannot be Zero]")
      }
    }
}
