package movie.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
@ConditionalOnClass(WebClient.class)
public class RestClientAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(RestClientAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public WebClient webClient() {
        logger.info("creating default web client");
        return WebClient.create();
    }
}
