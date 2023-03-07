object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    //Anonymous Function
    val number: (Int, Int) => String = (firstNum:Int, secondNum:Int)=>firstNum*secondNum+"abc"
    print(number)
  }
}