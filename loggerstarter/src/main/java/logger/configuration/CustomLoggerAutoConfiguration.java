package logger.configuration;

import logger.CustomLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomLoggerAutoConfiguration {

    @Bean
    @ConditionalOnProperty("timing-logger")
    public CustomLogger customLogger() {
        return new CustomLogger();
    }

    @Bean
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getField().getDeclaringClass());
    }
}
