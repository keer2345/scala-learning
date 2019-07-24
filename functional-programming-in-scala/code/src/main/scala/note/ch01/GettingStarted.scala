package note.ch01

object MyModule {

  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }


  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))

    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
  }

}

object AnonymousFunctions {

  import MyModule._

  def main(args: Array[String]): Unit = {
    println(formatResult("absolute value", -43, abs))
    println(formatResult("factorial", 8, factorial))
    println(formatResult("increment", 7, (x: Int) => x + 1))
    println(formatResult("increment2", 7, (x) => x + 1))
    println(formatResult("increment3", 7, x => x + 1))
    println(formatResult("increment4", 7, _ + 1))
    println(formatResult("increment5", 7, x => {
      val r = x + 1;
      r
    }))
  }
}

object MonomorphicBinarySearch {

  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def main(args: Array[String]): Unit = {
    println(findFirst(Array("a", "b", "c", "d"), "c"))
  }
}

object PolymorphicFunctions {
  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def isSorted[A](as: Array[A], p: (A, A) => Boolean): Boolean = {
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (p(as(n), as(n + 1))) false
      else go(n + 1)
    }

    go(0)
  }

  def main(args: Array[String]): Unit = {
    println(findFirst(Array(3, 4, 5, 6, 7, 8), (x: Int) => x == 5))
    println(isSorted(Array(3, 4, 5, 6, 7, 8, 9), (x: Int, y: Int) => x > y))
    println(isSorted(Array(3, 4, 5, 6, 7, 9, 8), (x: Int, y: Int) => x > y))
  }
}
