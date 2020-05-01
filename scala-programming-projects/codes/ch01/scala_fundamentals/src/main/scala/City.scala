case class City(name: String, urbanArea: Int)

object City {
  val London = City("London", 1738)
  val Lausanne = City("Lausanne", 41)
}

case class Person4(firstName: String, lastName: String, city: City)

object Person4 {
  def apply(fullName: String, city: City): Person4 = {
    val splitted = fullName.split(" ")
    new Person4(firstName = splitted(0), lastName = splitted(1), city = city)
  }
}

object Main extends App {
  // Uses the default apply method
  val m1 = Person4("Mikael", "Valot", City.London)
  // Call apply with fullName
  val m2 = Person4("Mikael Valot", City.London)
  // We can omit `apply`
  val m3 = Person4.apply("Nicolas Jorand", City.Lausanne)

  println(m1)
  println(m2)
  println(m3)
}

