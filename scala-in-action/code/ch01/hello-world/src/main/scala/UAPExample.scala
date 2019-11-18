class UAPExample {
  val someField = "hi"

  def someMethod = "there"
}

object UAPExample extends App {
  val o = new UAPExample
  println(o.someField)
  println(o.someMethod)
}
