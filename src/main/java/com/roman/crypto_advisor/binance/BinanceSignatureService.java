package com.roman.crypto_advisor.binance;

import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BinanceSignatureService {
    @Autowired
    private final BinanceSecurityProps securityProps;

    public String encode(MultiValueMap<String, String> requestHeaders) {
        final String paramString = mapToString(requestHeaders);
        log.info("params {}", paramString);
        return Hashing
                .hmacSha256(securityProps.getSecurityKey().getBytes(StandardCharsets.UTF_8))
                .hashString(paramString, StandardCharsets.UTF_8).toString();
    }

    private String mapToString(MultiValueMap<String, String> requestParams) {
        return requestParams
                .toSingleValueMap()
                .entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }
}
