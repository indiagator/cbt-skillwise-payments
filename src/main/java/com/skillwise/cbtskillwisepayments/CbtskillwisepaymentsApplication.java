package com.skillwise.cbtskillwisepayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CbtskillwisepaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbtskillwisepaymentsApplication.class, args);
    }

}
