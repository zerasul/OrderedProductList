package es.ind.ordercriteria.config.common;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("es.ind.ordercriteria.domain")
@EntityScan("es.ind.ordercriteria.domain")
@ComponentScan("es.ind.ordercriteria")
public class CommonConfig {


}
