package $package$.service

import scala.concurrent.Future
import scala.language.higherKinds


trait CalculatorService {

  def add(a: Long, b: Long): Future[Long]

}
