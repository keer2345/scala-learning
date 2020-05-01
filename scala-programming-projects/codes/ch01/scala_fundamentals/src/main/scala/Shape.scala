class Shape(val x: Int, val y: Int) {
  def description: String = s"shape at { $x, $y }"
}

class Rectangle(x: Int, y: Int, val width: Int, val height: Int)
  extends Shape(x, y) {
  override def description: String = {
    super.description + s" - rectangle $width * $height ."
  }

  def descThis = this.description

  def descSuper = super.description
}

object Shape extends App {
  val rect = new Rectangle(0, 3, 4, 5)
  println(rect.description)
  println(rect.descThis)
  println(rect.descSuper)
}
