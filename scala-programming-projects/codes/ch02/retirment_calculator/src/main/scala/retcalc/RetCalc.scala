package retcalc

import scala.annotation.tailrec


case class RetCalcParms(nbOfMonthsInRetirement: Int, netIncome: Int,
                        currentExpenses: Int, initialCapital: Double)

object RetCalc {

  def futureCapital(returns: Returns, nbOfMonths: Int, netIncome: Int,
                    currentExpenses: Int, initialCapital: Double) = {
    val monthlySavings = netIncome - currentExpenses

    (0 until nbOfMonths).foldLeft(initialCapital) {
      case (accumulated, month) =>
        accumulated * (1 + Returns.monthlyRate(returns, month)) + monthlySavings
    }
  }

  def simulatePlan(returns: Returns, params: RetCalcParms, nbOfMonthsSavings: Int,
                   monthOffset: Int = 0): (Double, Double) = {
    import params._

    val captialAtRetirement = futureCapital(
      returns = OffsetReturns(returns, monthOffset),
      nbOfMonths = nbOfMonthsSavings,
      netIncome = netIncome,
      currentExpenses = currentExpenses,
      initialCapital = initialCapital
    )
    val capitalAfterDeath = futureCapital(
      returns = OffsetReturns(returns, monthOffset + nbOfMonthsSavings),
      nbOfMonths = nbOfMonthsInRetirement,
      netIncome = 0,
      currentExpenses = currentExpenses,
      initialCapital = captialAtRetirement)

    (captialAtRetirement, capitalAfterDeath)
  }

  def nbOfMonthsSaving(params: RetCalcParms, returns: Returns): Int = {
    import params._
    @tailrec
    def loop(months: Int): Int = {
      val (capitalAtRetirement, capitalAfterDeath) = simulatePlan(returns, params, months)

      if (capitalAfterDeath > 0.0)
        months
      else
        loop(months + 1)
    }

    if (netIncome > currentExpenses)
      loop(0)
    else
      Int.MaxValue
  }
}
