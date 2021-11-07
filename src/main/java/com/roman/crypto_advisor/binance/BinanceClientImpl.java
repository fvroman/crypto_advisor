package com.roman.crypto_advisor.binance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RequiredArgsConstructor
@Service(value = "binanceClientImpl")
@Slf4j
public class BinanceClientImpl implements BinanceClient {
    @Autowired
    private WebClient webClient;
    @Autowired
    private BinanceSecurityProps props;
    @Autowired
    private BinanceSignatureService binanceSignatureService;

    public Mono<String> fetchStatus() {
        final Mono<String> response = getWebclient()
                .get()
                .uri("/sapi/v1/system/status")
                .exchangeToMono(this::retrieveResponseAsString);
        return response;
    }

    @Override
    public WebClient getWebclient() {
        return webClient;
    }

    public Mono<String> getAllCoinsInfo() {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final long epochSecond = System.currentTimeMillis();
        queryParams.add("timestamp", String.valueOf(epochSecond));
        final String encode = binanceSignatureService.encode(queryParams);
        queryParams.add("signature", encode);

        return getWebclient()
                .get()
                .uri("/sapi/v1/capital/config/getall", uriBuilder -> uriBuilder.queryParams(queryParams).build())
                .header("X-MBX-APIKEY", props.getAccountKey())
                .exchangeToMono(this::retrieveResponseAsString);
    }

    private Mono<String> retrieveResponseAsString(ClientResponse rawResponse) {
        final ClientResponse.Headers headers = rawResponse.headers();
        final HttpStatus httpStatus = rawResponse.statusCode();
        log.info("status {}", httpStatus);
        log.info("headers {}", headers.asHttpHeaders());
        return rawResponse.bodyToMono(String.class);
    }
}
