package com.example.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.trace("TRACE 로그 메세지");
        logger.debug("DEBUG 로그 메세지");
        logger.info("Info 로그 메세지");
        logger.warn("warn 로그 메세지");
        logger.error("error 로그 메세지");
    }
}
