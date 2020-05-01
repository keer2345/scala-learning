abstract class Shape2(val x: Int, val y: Int) {
  def description: String
  def hello = "hello world"
}

class Rectangle2(x: Int, y: Int, val width: Int, val height: Int)
  extends Shape2(x, y) {
  def description: String = {
    s"Rectangle $width * $height ."
  }

  override def hello: String = "Hello keer"

  def descThis = this.description

}

object Shape2 extends App {
  val rect = new Rectangle2(0, 3, 4, 5)
  println(rect.description)
  println(rect.descThis)
  println(rect.hello)
}
