package com.fullstack.promotion.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.DEFINED_PORT)
class PromotionRestControllerTest {

    private WebClient webClient;

    @BeforeEach
    public void before(){
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

    @Test
    void sendBirthdayMessage() {
        Mono<String> s = webClient.get()
                .uri("/api/$birthdate")
                .retrieve()
                .bodyToMono(String.class);
        s.block();

//        assertEquals("ok",s.block());
    }
}