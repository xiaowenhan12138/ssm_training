package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4jAndLog4j {
	public static void main(String[] args) {
		 final Logger LOGGER = LoggerFactory.getLogger(TestSlf4jAndLog4j.class);
         LOGGER.debug("TestSlf4jAndLog4j debug log：{}", "debug");
         LOGGER.info("TestSlf4jAndLog4j info log：{}", "info");
         LOGGER.error("TestSlf4jAndLog4j error log：{}", "error");
	}
}
