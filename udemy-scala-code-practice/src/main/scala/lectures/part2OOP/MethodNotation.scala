package lectures.part2OOP

import scala.language.postfixOps

object MethodNotation extends App{
  class Person(val name:String,movie:String){
    def likes(movie:String):Boolean=movie==this.movie
    def +(person:Person):String=s"${name} says hi to ${person.name}"

    //pre fix
    //while output type there must be space after method name
    //-->unary_!: String----->GIVES ERROR
    def unary_! :String=s"Hi! ${this.name} "

    //post fix
    def isAlive:Boolean=true

    //apply
    def apply():String=s"Hi $name"
  }
  val obj=new Person("Manish","I")
  println(obj.likes("I"))
  println(obj likes "I")

  //"Operators" in scala can also work as method
  var abhay=new Person("Abhay","Sahoo")
  println(obj+abhay)
  println(obj.+(abhay))

  //pre fix works with some of the operator + - ~ !
  println(!abhay) //this is equivalent to abhay.unary_!
  println(abhay.unary_!)

  //postfix notation is used with method without parameter
  println(obj isAlive)

  //apply
  println(obj.apply())
  println(obj())//   ()==apply()


  //EXERCISE
  class PersonExercise(val name:String,val age:Int=0){
    def +(name:String)=s"Hi $name"
    def +(name:String,e:Int)=s"$this .name"

    def unary_+ :String= s"${age+1}"

    def learns =s"${name} learns Scala"
  }
  val person=new PersonExercise("Manish")
  println(person + "Mash")

  println(+person)
  println(person learns)
}
