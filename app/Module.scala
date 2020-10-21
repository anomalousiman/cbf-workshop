import com.google.inject.AbstractModule
import models.{ProductDao, ProductRepository}
import play.api.{Configuration, Environment}

class Module(environment: Environment, configuration: Configuration)
    extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[ProductDao]).to(classOf[ProductRepository])
  }
}
