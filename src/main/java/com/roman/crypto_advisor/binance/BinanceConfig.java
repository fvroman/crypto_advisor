package com.roman.crypto_advisor.binance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BinanceConfig {
    @Bean
    public WebClient getWebclient() {
        return WebClient.create("https://api.binance.com");
    }
}
