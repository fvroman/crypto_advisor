package com.roman.crypto_advisor;

import com.roman.crypto_advisor.binance.BinanceSecurityProps;
import com.roman.crypto_advisor.binance.BinanceSignatureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

/**
 * contains sample data from binance api guide
 */
class BinanceSignatureServiceTest {
    public static final String SAMPLE_SECURITY_KEY = "NhqPtmdSJYdKjVHjA7PZj4Mge3R5YNiP1e3UZjInClVN65XAbvqqM6A7H5fATj0j";
    public static final String SAMPLE_ACCOUNT_KEY = "vmPUZE6mv9SD5VNHk4HlWFsOr6aKE2zvsw0MuIgwCIPy6utIco14y7Ju91duEh8A";
    private final BinanceSignatureService binanceSignatureService = new BinanceSignatureService(new BinanceSecurityProps(SAMPLE_ACCOUNT_KEY, SAMPLE_SECURITY_KEY));

    @Test
    void test() {
        final String signature = binanceSignatureService.encode(getSampleHeaders());
        System.out.println("sign " + signature);
        Assertions.assertEquals("c8db56825ae71d6d79447849e617115f4a920fa2acdcab2b053c4b2838bd6b71", signature);
    }

    private MultiValueMap<String, String> getSampleHeaders() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("symbol", "LTCBTC");
        headers.add("side", "BUY");
        headers.add("type", "LIMIT");
        headers.add("timeInForce", "GTC");
        headers.add("quantity", "1");
        headers.add("price", "0.1");
        headers.add("recvWindow", "5000");
        headers.add("timestamp", "1499827319559");
        return headers;
    }
}
