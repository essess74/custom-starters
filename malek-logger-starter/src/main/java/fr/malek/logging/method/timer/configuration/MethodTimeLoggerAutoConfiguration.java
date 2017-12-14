package fr.malek.logging.method.timer.configuration;

import fr.malek.logging.method.timer.DefaultMethodTimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodTimeLoggerAutoConfiguration {

    @Bean
    @ConditionalOnProperty("timing-logger")
    @ConditionalOnMissingBean
    public DefaultMethodTimeLogger methodTimeLogger() {
        return new DefaultMethodTimeLogger();
    }

    @Bean
    public Logger logger(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getField().getDeclaringClass());
    }
}
