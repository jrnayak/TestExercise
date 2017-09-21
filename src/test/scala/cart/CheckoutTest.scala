package cart

import org.scalatest._


class CheckoutTest extends FlatSpec with GivenWhenThen with Matchers with OptionValues {
  val checkout = new Checkout

  "A checkout" should "scan apples" in {
    checkout scan "apple" should not be empty
  }

  it should "scan oranges" in {
    checkout scan "orange" should not be empty
  }

  it should "not scan banana" in {
    checkout scan "banana" should be (empty)
  }
  it should "return 60p as cost for an apple" in {
    (checkout scan "apple").value should be (0.60)
  }

  it should "return 25p as cost for an orange" in {
    (checkout scan "orange").value should be (0.25)
  }
  it should "return 1.45 GBP for three apples and one orange" in {

    When("scanning three apples and one orange")

    val scannedCost = checkout scan List("apple", "apple", "orange", "apple")

    Then("should return a total cost of 1.45 GBP")
    scannedCost should be (2.05)
  }
}
