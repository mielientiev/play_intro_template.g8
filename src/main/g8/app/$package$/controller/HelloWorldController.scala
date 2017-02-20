package $package$.controller

import javax.inject.{Inject, Singleton}

import $package$.service.CalculatorService
import play.api.mvc.{Action, Controller}
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits._


@Singleton
class HelloWorldController @Inject()(calculatorService: CalculatorService) extends Controller {

  def hello(name: String) = Action {
    Ok(Json.obj("greeting" -> s"Hello, $name"))
  }

  def calculateTwoValues(a: Long, b: Long) = Action.async {
    calculatorService.add(a, b).map(sum => Ok(Json.obj("sum" -> sum)))
  }

}
