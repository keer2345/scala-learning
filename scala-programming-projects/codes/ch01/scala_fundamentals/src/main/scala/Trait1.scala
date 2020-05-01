trait Description {
  def description: String
}

trait Coordinates extends Description {
  def x: Int

  def y: Int

  override def description: String = s"Coordinates ( $x , $y )"
}

trait Area {
  def area: Double
}

class Rectangle3(val x: Int, val y: Int, val width: Int, val height: Int)
  extends Coordinates with Description with Area {
  val area: Double = width * height

  override def description: String = super.description + s" - Rectangle $width * $height"
}


object Trait1 extends App {
  val rect = new Rectangle3(0, 3, 4, 6)
  println(rect.area)
  println(rect.description)
}
