class Robot(val name: String = "Unknow") {
  def welcome(n: String) = "Welcome $n! My name is $name"
}

class ItalianRobot(name: String) extends Robot(name) {
  override def welcome(n: String): String = s"Benvenuto $n!"
}
class EnglishRobot(name: String, country: String) extends Robot(name) {
  override def welcome(n: String): String =
    s"Welcome $n from the country of $country"
}
