package com.ava.kone.pricing.web;


@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class KonePricingWebApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KonePricingWebApplication.class);
        app.run(args);
    }
}
