package cart

class Checkout {
  val ApplePrice = BigDecimal("0.60")
  val OrangePrice = BigDecimal("0.25")
  val ZeroPrice = BigDecimal("0.00")

  val Apple = "apple"
  val Orange = "orange"

  def scan(product: String): Option[BigDecimal] = product match {
    case Apple => Some(ApplePrice)
    case Orange => Some(OrangePrice)
    case _ => None
  }

  def scan(products: Seq[String]): BigDecimal = {
    products.map(scan).flatten.fold (ZeroPrice)(_+_)-
      discount(products, 2, Apple) - discount(products, 3, Orange)
  }

  def discount(products: Seq[String], discountedQuantity: Int, discountedProduct: String) =
    products.count(_ == discountedProduct) / discountedQuantity * scan(discountedProduct).get
}
