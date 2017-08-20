package bill

import config._
import scala.math.BigDecimal.RoundingMode

/** Billing snacks
  */
case class Billing(items: List[String]) {

  val total = items.map(i => prices.get(i.toLowerCase).getOrElse(("","",0))._3).sum/100d /*step1*/

  val allDrinks = items.forall(i => prices.get(i.toLowerCase).getOrElse(("", "", 0))._2 == "drink")

  lazy val allCold = items.forall(i => prices.get(i.toLowerCase).getOrElse(("", "", 0))._1 == "cold")

  lazy val srvCharge: Double = if(allDrinks) 0
    else if(allCold) SC.get("cold").get * total / 100
    else (SC.get("hot").get * total / 100) min 20

  def getTotal = BigDecimal(total + srvCharge).setScale(2, RoundingMode.HALF_EVEN)


}

/** Rates config
  */
object config {

  val prices = Map("coffee" -> ("hot", "drink",100), "steak_sandwich" -> ("hot", "food", 450)
    , "cola" -> ("cold", "drink",50), "cheese_sandwich" -> ("cold","food", 200)) //step1

  val MAX_SC = 2000

  val SC = Map("hot" -> 20, "cold" -> 10)

}
