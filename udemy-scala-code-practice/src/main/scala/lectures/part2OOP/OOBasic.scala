package lectures.part2OOP

object OOBasic extends App {
  val writerObject = new Writer("Manish", "Mishra", 2001)
  val novelObject = new Novel("Scala", 2023, writerObject)
  println(writerObject.fullName())
  println(novelObject.authorAge())
  println(novelObject.isWrittenBy("Manish"))


  val counter = new Counter
  println(counter.methodCount)
  counter.inc.print
  counter.inc(10).print

}


//1-->Practice Code
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): Int = year - author.year

  def isWrittenBy(author: String): Boolean = author == this.author

  def copy(newYearRelease: Int): Novel = new Novel(name, newYearRelease, author)
}

//2-->Practice Code
class Counter(val value: Int = 0) {
  def methodCount = value

  def inc: Counter = {
    new Counter(value + 1)
  }

  def dec: Counter = {
    new Counter(value - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(value)
}
