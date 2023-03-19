package lectures.part2OOP

import lectures.part2OOP.package_scala.{SPEED_OF_LIGHT, sayHello}

object PackageAndImport extends App {
  //Either import or give full path name in same package
  //lectures.part2OOP.CaseClasses. Example
  val caseClass= lectures.part2OOP.CaseClasses.Person("Hi",22)
  println(caseClass.name)

  //Imported method
  sayHello
  println(SPEED_OF_LIGHT)
  //to use class as other in package(aliases)
  // classname => sortWayToCall
}
