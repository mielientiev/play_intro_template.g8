package $package$.module

import com.google.inject.AbstractModule
import $package$.service.{CalculatorService, InMemoryCalculatorService}
import net.codingwell.scalaguice._

class ApplicationModule extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[CalculatorService].to[InMemoryCalculatorService].asEagerSingleton()
  }

}
