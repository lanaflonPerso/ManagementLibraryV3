package mbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableFeignClients("mbooks")
public class MbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbooksApplication.class, args);
	}

}
