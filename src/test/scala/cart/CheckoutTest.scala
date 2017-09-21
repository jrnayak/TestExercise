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
    (checkout scan "apple").value should be (BigDecimal("0.60"))
  }

  it should "return 25p as cost for an orange" in {
    (checkout scan "orange").value should be (BigDecimal("0.25"))
  }
  it should "return 1.45 GBP for three apples and one orange" in {

    When("scanning three apples and one orange")

    val scannedCost = checkout scan List("apple", "apple", "orange", "apple")

    Then("should return a total cost of 1.45 GBP")
    scannedCost should be (BigDecimal("1.45"))
  }
  it should "get the second apple for free" in {
    When("scanning two apples")
    val scannedCost = checkout scan List("apple", "apple","apple")

    Then("should be only 1.20p as the second is free")
    scannedCost should be (BigDecimal("1.20"))
  }

  it should "get the second orange for free" in {
    When("scanning two oranges")
    val scannedCost = checkout scan List("orange", "orange","orange")

    Then("should be only 50p as the second is free")
    scannedCost should be (BigDecimal("0.50"))
  }
  it should "get one apple and one orange free" in {
    When("scanning three apples and four oranges")
    val scannedCost = checkout scan List("apple", "orange", "orange", "apple", "orange", "apple", "orange")

    Then("should cost only 1 GBP and 95p as one apple and one orange are free")
    scannedCost should be (BigDecimal("1.95"))
  }
}
