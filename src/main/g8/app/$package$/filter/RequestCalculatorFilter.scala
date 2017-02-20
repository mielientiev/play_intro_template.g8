package $package$.filter

import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject

import akka.stream.Materializer
import play.api.Logger
import play.api.mvc.{Filter, RequestHeader, Result}
import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Future

class RequestCalculatorFilter @Inject()(implicit val mat: Materializer) extends Filter {

  private val counter = new AtomicLong(0)

  override def apply(f: (RequestHeader) => Future[Result])(rh: RequestHeader): Future[Result] = {
    val value = counter.incrementAndGet()
    f(rh).map { result =>
      Logger.info(s"Request #$value")
      result
    }
  }
}


