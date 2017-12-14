package fr.malek.logging.method.configuration;


import fr.malek.logging.method.timer.DefaultMethodTimeLogger;
import fr.malek.logging.method.timer.configuration.MethodTimeLoggerAutoConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * The type Method time logger auto configuration test.
 */
public class MethodTimeLoggerAutoConfigurationTest {

    private ConfigurableApplicationContext context;

    @AfterEach
    public void before() {
        context.close();
    }

    private void run(Class<?> clazz, String... args) {
        context = new SpringApplication(clazz).run(args);
    }

    /**
     * Test that default method time logger is created when timing logger property is true.
     *
     * @throws Exception the exception
     */
    @Test
    public void testThatDefaultMethodTimeLoggerIsCreatedWhenTimingLoggerPropertyIsTrue() throws Exception {
        run(TestMethodTimeLoggerAutoConfiguration.class, "--timing-logger=true");
        assertNotNull(context.getBean(DefaultMethodTimeLogger.class));
    }

    /**
     * Test that default method time logger is not created when timing logger property is false.
     *
     * @throws Exception the exception
     */
    @Test
    public void testThatDefaultMethodTimeLoggerIsNotCreatedWhenTimingLoggerPropertyIsFalse() throws Exception {
        run(TestMethodTimeLoggerAutoConfiguration.class, "--timing-logger=false");
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(DefaultMethodTimeLogger.class));
    }

    /**
     * Test that default method time logger is not created when timing logger property doesnt exist.
     *
     * @throws Exception the exception
     */
    @Test
    public void testThatDefaultMethodTimeLoggerIsNotCreatedWhenTimingLoggerPropertyDoesntExist() throws Exception {
        run(TestMethodTimeLoggerAutoConfiguration.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(DefaultMethodTimeLogger.class));
    }

    @TestConfiguration
    static class TestMethodTimeLoggerAutoConfiguration extends MethodTimeLoggerAutoConfiguration {
        @Autowired
        private Logger logger;
    }
}
