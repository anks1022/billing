package bill

import config._
import scala.math.BigDecimal.RoundingMode

/** Billing snacks
  */
case class Billing(items: List[String]) {

  val total = items.map(i => prices.get(i.toLowerCase).getOrElse(("","",0))._3).sum/100d /*step1*/
}

/** Rates config
  */
object config {

  val prices = Map("coffee" -> ("hot", "drink",100), "steak_sandwich" -> ("hot", "food", 450)
    , "cola" -> ("cold", "drink",50), "cheese_sandwich" -> ("cold","food", 200)) //step1

}
