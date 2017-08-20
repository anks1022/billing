package bill

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ankur on 20/08/2017.
  */

@RunWith(classOf[JUnitRunner])
class BillingTest  extends FunSuite {

  import bill.Billing

  test("Bill no item") {
    assert(Billing(List()).total == 0)
  }

  test("Bill some items ") {
    assert(Billing(List("Coffee", "Cheese_Sandwich", "Cola")).total == 3.5)
  }

  test("Bill some more items ") {
    assert(Billing(List("Coffee", "Cheese_Sandwich", "Cola")).getTotal == 4.20)

    assert(Billing(List("Coffee",  "Cola")).getTotal == 1.50)

    assert(Billing(List("Cheese_Sandwich",  "Cola")).getTotal == 2.75)

    assert(Billing(List("Coffee", "Cheese_Sandwich", "Cola",
      "Coffee", "Cheese_Sandwich", "Cola","steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
    "Coffee", "Cheese_Sandwich", "Cola","steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
    "Coffee", "Cheese_Sandwich", "Cola","steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
    "Coffee", "Cheese_Sandwich", "Cola","steak_sandwich","steak_sandwich","steak_sandwich",
      "Coffee", "Cheese_Sandwich", "Cola")).getTotal == 106.20)

    assert(Billing(List("steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich",
      "steak_sandwich","steak_sandwich","steak_sandwich","steak_sandwich" )).getTotal == 182.00)

  }
}
