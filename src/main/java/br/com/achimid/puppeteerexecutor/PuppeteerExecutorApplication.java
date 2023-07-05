package br.com.achimid.puppeteerexecutor;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class PuppeteerExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuppeteerExecutorApplication.class, args);
	}

}
