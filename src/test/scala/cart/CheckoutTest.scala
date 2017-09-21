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
}
