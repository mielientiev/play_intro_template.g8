package $package$.controller

import $package$.service.InMemoryCalculatorService
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json
import play.api.mvc._
import play.api.test.Helpers._
import play.api.test._

import scala.concurrent.Future

class HelloWorldControllerSpec extends PlaySpec with Results {

  "Hello world controller" should {
    "should add 2 numbers" in {
      val calculatorService = new InMemoryCalculatorService
      val controller = new HelloWorldController(calculatorService)
      val result: Future[Result] = controller.calculateTwoValues(10, 22).apply(FakeRequest())
      val bodyText = contentAsJson(result)
      bodyText mustEqual Json.obj("sum" -> 32)
    }
  }

}
