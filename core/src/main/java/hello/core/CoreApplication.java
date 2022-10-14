package hello.core;

import hello.core.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	@Autowired OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}
