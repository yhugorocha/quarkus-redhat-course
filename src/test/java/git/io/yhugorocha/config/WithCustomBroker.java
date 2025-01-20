package git.io.yhugorocha.config;

import io.quarkus.test.common.QuarkusTestResource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@QuarkusTestResource(CustomBrokerResource.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithCustomBroker {
    String nameDatabase();
    String username();
    String password();
    String port() default "5432";
}
