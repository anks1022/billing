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


}
