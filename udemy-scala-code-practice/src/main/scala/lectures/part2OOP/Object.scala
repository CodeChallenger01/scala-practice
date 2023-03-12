package lectures.part2OOP

object Object extends App{

  //Person is only single instance
  object Person{
    val PIE=3.14
  }
  val obj=Person
  val obj1=Person
  //it give true because Person having object Person is only single instance
  println(obj==obj1)
  println(Person.PIE)

}
