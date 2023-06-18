package com.wallet.transactionmanagementservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class TransactionManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementServiceApplication.class, args);
	}

}
