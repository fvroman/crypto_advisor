package com.roman.crypto_advisor.binance;

import reactor.core.publisher.Mono;

public interface BinanceApi {
    Mono<String> getStatus();

    Mono<String> getAllCoinsInfo();

}
