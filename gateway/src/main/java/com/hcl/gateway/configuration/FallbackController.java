package com.hcl.gateway.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/userFallback")
    public Mono<String> userServiceFallBack() {
        return Mono.just("User Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/questionFallback")
    public Mono<String> questionServiceFallBack() {
        return Mono.just("Question Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/answerFallback")
    public Mono<String> answerServiceFallBack() {
        return Mono.just("Answer Service is taking too long to respond or is down. Please try again later");
    }
}
