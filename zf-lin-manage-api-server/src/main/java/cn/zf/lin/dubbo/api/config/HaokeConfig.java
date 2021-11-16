package cn.zf.lin.dubbo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class linConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
