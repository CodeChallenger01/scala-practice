package lectures.part2OOP

object CaseClasses  extends  App{

  case class Person(name: String, num: Int)

  // class parameter are fields
  val obj=Person("Manish",21)
  println(obj.name)

  //sensible toString
  println(obj) //same as toString Syntactic Sugar
  println(obj.toString)

  //every instance of case class are same
  val obj1=Person("Manish",21)
  println(obj==obj1)

  //copy
  val jim=obj1.copy(num=34)
  println(jim)

  //it has companion object
  val thePerson = Person
  val marry =Person("Marry",24)

  case object Person{
    //same as case class except parameter and companion object
  }
}
