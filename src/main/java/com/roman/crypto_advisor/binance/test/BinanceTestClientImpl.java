package com.roman.crypto_advisor.binance.test;

import com.roman.crypto_advisor.binance.BinanceClientImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Service(value = "binanceTestClientImpl")
public class BinanceTestClientImpl extends BinanceClientImpl {
    @Autowired
    @Qualifier("testWebClient")
    private WebClient testWebClient;

    @Override
    public WebClient getWebclient() {
        return testWebClient;
    }
}
