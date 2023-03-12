package lectures.part2OOP

object InheritanceAndTraits extends App{
  class Shape{
    def shapeName=println("Shape Doesn't Identified")
    protected val shape:String="Hi from Shape Class"
  }
  class Rectangle extends Shape{
    override def shapeName=println("It is rectangle")
    println(shape)
  }
  class Square(side:Int) extends Rectangle{
    override def shapeName():Unit={
      println("Area of Square :"+(side*side))
    }
  }
  val obj=new Rectangle
  obj.shapeName

  val obj1=new Square(2)
  obj1.shapeName()

  //polymorphism
  val unknownShape:Shape= new Rectangle
  unknownShape.shapeName

  //

}
