package com.roman.crypto_advisor.binance;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class BinanceController {

    private final BinanceClientImpl binanceClient;

    @GetMapping("/")
    public Mono<String> getStatus() {
        return binanceClient.fetchStatus();
    }
}
