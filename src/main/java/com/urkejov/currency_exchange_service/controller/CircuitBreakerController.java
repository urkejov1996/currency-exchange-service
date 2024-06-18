package com.urkejov.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    @GetMapping("/sample-api")
//     @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleApi() {
        logger.info("Sample Api call received");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-url", String.class);
        return forEntity.getBody();
//        return "sample-api";

    }


    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    private String hardcodedResponse(Exception exception) {
        return "fallback response";
    }
}
