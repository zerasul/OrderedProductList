package es.ind.ordercriteria;

import es.ind.ordercriteria.config.common.CommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication()
@Import(CommonConfig.class)
public class OrdercriteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdercriteriaApplication.class, args);
	}

}
