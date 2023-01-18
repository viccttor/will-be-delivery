package br.com.willBeDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WillBeDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WillBeDeliveryApplication.class, args);
	}

}
