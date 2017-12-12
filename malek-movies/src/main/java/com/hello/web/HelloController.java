package com.hello.web;

import fr.malek.logging.annotation.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Logger logger;

    @Loggable
    @RequestMapping
    public String hello() {
        logger.info("hee");
        return "hello world";
    }
}