package com.roman.crypto_advisor.binance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BinanceController implements BinanceApi {

    @Qualifier("binanceClientImpl")
    @Autowired
    private BinanceClient binanceClient;

    @Override
    @GetMapping("/")
    public Mono<String> getStatus() {
        return binanceClient.fetchStatus();
    }

    @Override
    @GetMapping("/allCoins")
    public Mono<String> getAllCoinsInfo() {
        return binanceClient.getAllCoinsInfo();
    }
}
