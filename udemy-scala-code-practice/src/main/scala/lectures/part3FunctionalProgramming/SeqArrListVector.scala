package lectures.part3FunctionalProgramming

import scala.util.Random

object SeqArrListVector extends App {

  //ABOUT SEQUENCE Immutable
  val aSequence:Seq[Int]=Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(1))
  println(aSequence ++Seq(5,6,7,8))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq [Int]=1 to 10
  aRange.foreach(println)

  //ABOUT List
  val aList=List(1,2,3,4)
  //prepending
  val prepending=42::aList //::-->+:
  println(prepending)
  //  appending
  val appendding=aList:+List(21) //:: same as :+
  println(appendding)
  //to repeat avalue or element
  val repeatElement=List.fill(5)("Mango")
  println(repeatElement)
  //to makeString-->mkString(" ,")
  println(aList.mkString(","))

  //Arrays Mutable
  val number=Array(2,4,6,7,8)
  val treeElements=Array.ofDim[Int](3)
  println(treeElements)
  //mutable
  number(2)=100// same as number.update(2,10)
  println(number.mkString(","))

  //array to seq
  val numberSeq: Seq[Int]= number //It give ArraySeq
  println(numberSeq)


  //VECTOR immutable

  val numVector: Vector[Int]=Vector(1,2,3)
  println(numVector)

  //  list V/S Vector

  val maxRuns=1000
  val maxCapacity=1000000
  def getWriteTime(collection: Seq[Int]):Double={
    val r=new Random
    val times =for{
      it<- 1 to maxRuns
    } yield {
      val currentTime=System.nanoTime()
      collection.updated(r.nextInt(maxCapacity),r.nextInt())
      System.nanoTime()-currentTime
    }
    times.sum*1.0/maxRuns
  }
  val numberList =(1 to maxCapacity).toList
  val numberVector=(1 to maxCapacity).toVector

  //keeps reference to tail
  //updating an element in the middle takes long
  println(getWriteTime((numberList)))
  //depth of the time is small
  //need to replace an entire 32 element chunk
  println(getWriteTime((numberVector)))
}
