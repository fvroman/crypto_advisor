package com.roman.crypto_advisor.binance;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:keys.properties")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BinanceSecurityProps {
    @Value("${acc}")
    private String accountKey;
    @Value("${sec}")
    private String securityKey;
}