package com.htx.api.config;

import com.htx.api.client.learning.fallback.LearningClientFallback;
import com.htx.api.client.remark.fallback.RemarkClientFallback;
import com.htx.api.client.trade.fallback.TradeClientFallback;
import com.htx.api.client.user.fallback.UserClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {
    @Bean
    public LearningClientFallback learningClientFallback(){
        return new LearningClientFallback();
    }

    @Bean
    public TradeClientFallback tradeClientFallback(){
        return new TradeClientFallback();
    }

    @Bean
    public UserClientFallback userClientFallback(){
        return new UserClientFallback();
    }

    @Bean
    public RemarkClientFallback remarkClientFallback(){
        return new RemarkClientFallback();
    }
}
