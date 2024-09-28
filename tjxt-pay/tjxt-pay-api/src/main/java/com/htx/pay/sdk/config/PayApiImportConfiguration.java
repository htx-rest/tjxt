package com.htx.pay.sdk.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.htx.pay.sdk.client")
public class PayApiImportConfiguration {

}