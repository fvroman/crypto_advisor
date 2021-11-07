package com.roman.crypto_advisor.binance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    @Primary
    public WebClient getWebclient() {
        return WebClient.builder().baseUrl("https://api.binance.com").codecs(configurer -> configurer
                .defaultCodecs()
                .maxInMemorySize(16 * 1024 * 1024))
                .build();
    }

    @Bean(name = "testWebClient")
    public WebClient getTestWebclient() {
        return WebClient
                .builder()
                .baseUrl("https://testnet.binance.vision").
                        codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                .build();
    }
}
