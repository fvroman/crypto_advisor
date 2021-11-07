package com.roman.crypto_advisor.binance.test;

import com.roman.crypto_advisor.binance.BinanceApi;
import com.roman.crypto_advisor.binance.BinanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test/")
public class BinanceTestController implements BinanceApi {

    @Autowired
    @Qualifier(value = "binanceTestClientImpl")
    private BinanceClient client;

    @Override
    @GetMapping
    public Mono<String> getStatus() {
        return client.fetchStatus();
    }

    @Override
    @GetMapping("allCoins")
    public Mono<String> getAllCoinsInfo() {
        return client.getAllCoinsInfo();
    }
}
