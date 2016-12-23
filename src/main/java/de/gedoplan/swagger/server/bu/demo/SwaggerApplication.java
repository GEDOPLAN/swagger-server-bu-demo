package de.gedoplan.swagger.server.bu.demo;

import de.gedoplan.swagger.server.bu.demo.resource.CustomerAPI;
import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Dominik Mathmann
 */
@ApplicationPath("rest")
public class SwaggerApplication extends Application {

  public SwaggerApplication()
  {
    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[]{"http"});
    beanConfig.setHost("localhost:8080/swagger-server-bu-demo-1.0-SNAPSHOT");
    beanConfig.setBasePath("/rest");
    beanConfig.setResourcePackage("de.gedoplan.swagger.server.bu.demo.resource");
    beanConfig.setScan(true);
  }

  @Override
  public Set<Class<?>> getClasses()
  {
    HashSet<Class<?>> set = new HashSet<>();

    set.add(CustomerAPI.class);

    set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
    set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    return set;
  }

}
