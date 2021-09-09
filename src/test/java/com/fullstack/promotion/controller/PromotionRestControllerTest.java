package com.fullstack.promotion.controller;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class PromotionRestControllerTest {

    @Test
    public void sendEmailTest(){
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20000)
                .responseTimeout(Duration.ofMillis(20000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(10000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(10000, TimeUnit.MILLISECONDS)));

        WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://127.0.0.1:8080/api/$birthdate")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("======================");
    }

}