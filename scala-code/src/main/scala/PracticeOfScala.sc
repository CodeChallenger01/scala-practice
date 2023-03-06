//Hello World program
print("Hello World !")

//Add two number without using val
1+1

//To add two number and above code

//To create class
class Hello

//Instant of Class
val obj=new Hello
obj.toString

//To print Hello World through Class
class Hello{
  println("Hello World")
}
val obj=new Hello

//Parameter Class
class Parameter(message:String){
  println(message)
}
new Parameter("Hi from Manish Mishra")


/*
Use def for
Additional Constructor
*/
class AdditionalConstructor(message:String){
  def showDetails(): Unit = {
    println("Software Intern")
  }
  println(message)
}
var s=new AdditionalConstructor("Hi")
s.showDetails()

/*
Immutable Fields
 */
class ImmutableClass{
  val input:String="Hi this is immutable Class"
}
(new ImmutableClass).input

/*
Mutable Fields
*/
class MutableClass{
  var in:Int=21
}
val obj=new MutableClass()
print(obj.in)
obj.in=100
print(obj.in)

/*
Promote Class Parameters
 */
class PromoteClass(val userID:Int)
val message=new PromoteClass(21)
print(message.userID)

class TrainHour(val hr:Int, val min:Int)
val access=new TrainHour(1,28)
print(access.hr,  access.min)

/*
Method Example
 */
def hello="Hi"
hello

//Method with parameter
def add(num1:Int,num2:Int):Int= num1+num2
add(4,5)

/*
Infix, Prefix and postfix operator
 */
//Infix
val in="Manish Mishra".split(" ")
//prefix operator are +,-,!,~
!true
//Postfix
"Manish Mishra".split(" ").size


/*
Argument
 */
//Equality
new String("scala")==new String("scala")
//Also we can use ne & eq for comparision
null ne new String("scala")

//default argument
def name(first:String="",last:String=""):String=first+" "+last
name("Manish","Mishra")



//case class
case class Test(input:String="")
val name=Test("Manish")
print(name.input)


//Array

val array=Array(1,2,3,4,5)
for(i<-0 to array.length-1){
  print(" "+i)
}


//Vector
val s=Vector("Hello World")
s.map(str=>str.split(" "))//Array[String]
s.flatMap(str=>str.split(" "))//Vector[String]
print(s)


//for expression
for{
  n<-1 to 3
  m<-1 to n
}yield n*m



//Inheritance
class Animal{
  def sound(): Unit = {
    print("Hi bro Animal Class")
  }
}
class Dog extends Animal{
  override def sound(): Unit = {
    print("Bark")
  }
  super.sound()
}


//Use trait for muliple inheritance
trait Swimmer{
  def  swim(): Unit = {
    print("From Swimmer trait")
  }
}
class Fish extends Animal with Swimmer{
  override def swim(){
    print("From Fish Class")
  }
}

