object Monomorphic {
  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def findFirst2[A](as: Array[A], key: A): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (as(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def findFirst3[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): A = {
    as(0)
  }

  def main(args: Array[String]): Unit = {
    println(findFirst(Array("1", "2", "3", "4"), "3"))
    println(findFirst2(Array(1, 2, 3, 4), 4))
    println(findFirst3(Array(1, 2, 3, 4), (x: Int) => x == 1))
  }
}
