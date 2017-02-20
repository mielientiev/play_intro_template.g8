package $package$.module

import com.google.inject.AbstractModule
import com.mielientiev.service.{CalculatorService, InMemoryCalculatorService}
import net.codingwell.scalaguice._

class ApplicationModule extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[CalculatorService].to[InMemoryCalculatorService].asEagerSingleton()
  }

}
