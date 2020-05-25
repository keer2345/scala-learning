package retcalc

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.WordSpec
import org.scalatest.matchers.must.Matchers

class ReturnsSpec extends WordSpec with Matchers with TypeCheckedTripleEquals {
  "VariableReturns.fromUntil" should {
    "keep only a window of the returns" in {
      val variableReturns = VariableReturns(Vector.tabulate(12) {
        i =>
          val d = (i + 1).toDouble
          VariableReturn(f"2017.$d%02.0f", d)
      })

      variableReturns.fromUntil("2017.07", "2017.09").returns should ===(Vector(
        VariableReturn("2017.07", 7.0),
        VariableReturn("2017.08", 8.0)))
    }
  }
}
