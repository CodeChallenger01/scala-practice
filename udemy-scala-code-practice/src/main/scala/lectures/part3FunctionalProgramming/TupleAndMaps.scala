package lectures.part3FunctionalProgramming

object TupleAndMaps extends App {

  //Tuple = finite ordered List
  val aTuple: (Int, String) = new Tuple2(2, "Hello, Tuple")
  //Tuple2(2,"Hello, Tuple")--->(2,"Hello")==>Syntactic Sugar
  // we can take new or discard it also

  //to access element
  println(aTuple._2)

  //to Copy
  println(aTuple.copy(_2 = "good bye"))
  //to Swap
  println(aTuple.swap)

  //MAPS ==== keys,value   immutable
  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), ("Manish", 422), "Abhay" -> 32).withDefaultValue(-1)
  println(phonebook)
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  //if key not present in map then with map use .withDefaultValue(-1)
  println(phonebook("Ravi"))

  val newPair = "Ravi" -> 31
  val newPhonebook = phonebook + newPair
  println(newPhonebook.mkString(","))

  //map, filter,flatMap
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //NOT WORKES
  println(phonebook.filterKeys(x => x.startsWith(("J"))))
  println(phonebook.mapValues(num => num * 10))

  //conversion to another collection
  println(phonebook.toList)
  println(List(("ABC", 332)).toMap)

  //GROUP BY
  val names = List("Bob", "Manish", "Mohan", "Ravi", "Abhay")
  println(names.groupBy(name => name.charAt(0)))

  /*
      Exercises
      of Map
  */

  //1->
  val mapExercise: Map[String, Int] = Map("Jim" -> 21, "JIM" -> 25)
  println(mapExercise.map(pair => pair._1.toLowerCase -> pair._2))

  //2--> SOCIAL MEDIA

  /*
  * Overly Simplified social network based on maps
  * Person =String
  *  add a person to the network
  *  remove
  *  friend(mutual)
  *  unfriend
  *
  *  number of friends of a person
  *  person with most friends
  *  how many people have no friends
  *  if there is social connection between two people (direct or not)
  */
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], netwrkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) netwrkAcc
      else removeAux(friends.tail, unfriend(netwrkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Manish")
  println(network)
  println(friend(network, "Bob", "Manish"))
  println(unfriend(friend(network, "Bob", "Manish"), "Bob", "Manish"))
  println(remove(friend(network, "Bob", "Manish"), "Bob"))

  //JIM,BOB,MARY
  val people = add(add(add(empty, "Bob"), "Manish"), "Ravi")
  val raviManish = friend(people, "Manish", "Ravi")
  val manishBob = friend(raviManish, "Bob", "Manish")
  println(manishBob)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains((person))) 0
    else network(person).size

  println(nFriends(manishBob, "Bob"))

  def mostFriend(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriend(network))

  def nPeopleWithNoFriend(network: Map[String, Set[String]]): Int = {
    network.filter(pair => pair._2.isEmpty).size
  }

  println((nPeopleWithNoFriend(manishBob)))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean =
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(manishBob, "Manish", "Bob"))
  println(socialConnection(network, "Manish", "Bob"))
}
