package com.roman.crypto_advisor.binance;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface BinanceClient {
    Mono<String> fetchStatus();

    Mono<String> getAllCoinsInfo();

    WebClient getWebclient();
}
