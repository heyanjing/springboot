package com.he.maven.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by heyanjing on 2017/5/24 17:25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {
    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void log() {
        log.trace("I am trace log.");
        log.debug("I am debug log.");
        log.warn("I am warn log.");
        log.error("I am error log.");
    }
}
