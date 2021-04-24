package com.roman.crypto_advisor.binance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
@Slf4j
public class BinanceClientImpl implements BinanceClient {
    private final WebClient webClient;

    public Mono<String> fetchStatus() {
        return webClient.get().uri("/wapi/v3/systemStatus.html").retrieve().bodyToMono(String.class);
    }

}
