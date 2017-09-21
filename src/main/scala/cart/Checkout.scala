package cart

class Checkout {
  val ApplePrice: Double = 0.60
  val OrangePrice: Double = 0.25
  val ZeroPrice: Double = 0.00

  val Apple = "apple"
  val Orange = "orange"

  def scan(product: String): Option[Double] = product match {
    case Apple => Some(ApplePrice)
    case Orange => Some(OrangePrice)
    case _ => None
  }

  def scan(products: Seq[String]): Double = {
    products.map(scan).flatten.fold (ZeroPrice)(_+_)
  }
}
