package session06

object Ordinal extends App {

  def oridinal(x: Int) = x match {
    case 1 => println("1st")
    case 2 => println("2nd")
    case 3 => println("3rd")
    case 4 => println("4th")
    case _ => println("Cannot do beyond 4")
  }

  def printType(obj: AnyRef) = obj match {
    case x: String => println("This is string")
    case x: List[_] => println("This is list")
    case x: Array[_] => println("This is array")
    case x: java.util.Date => println("This is date")
    case _ => println("This is other type")
  }

  def rangeMatcher(num: Int) = num match {
    case x if x <= 10 => println("with in 0 to 10")
    case x if x <= 100 => println("with in 11 to 100")
    case x if x <= Integer.MAX_VALUE => println("beyond 100")
  }

  val suffixes = List("th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th")

  def suff(num: Int) = num match {
    case x if 10 to 20 contains x => println(num + "th")
    case x => println(x + suffixes(num % 10))
  }

  oridinal(3)
  oridinal(5)

  printType("Hello")
  printType(List(1, 2, 3))
  printType(Array(1, 2, 3))
  printType((1, 2, 3))

  rangeMatcher(4)
  rangeMatcher(40)
  rangeMatcher(400)

  suff(13)
  suff(33)
}
