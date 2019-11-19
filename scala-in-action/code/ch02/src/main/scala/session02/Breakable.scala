package session02

object Breakable extends App {
  val breakException = new RuntimeException("break exception")

  def breakable(op: => Unit): Unit = {
    try {
      op
    } catch {
      case _ =>
    }
  }

  def break = throw breakException

  def install = {
    val env = System.getenv("SCALA_HOME")
    if (env == null) break
    println("found scala home lets do the real work")
  }

  breakable {
    val env = System.getenv("SCALA_HOME")
    if (env == null) break
    println("found scala home lets do the real work")
  }
}
