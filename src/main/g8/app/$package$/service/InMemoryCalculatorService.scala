package $package$.service

import javax.inject.Singleton
import scala.concurrent.Future

@Singleton
class InMemoryCalculatorService extends CalculatorService {

  override def add(a: Long, b: Long): Future[Long] = Future.successful(a+b)

}
