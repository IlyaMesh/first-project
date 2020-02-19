/*
 * Copyright
 */

package com.firstproject.testmodule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example about how to use slf4j.
 *
 * @since 0.0.1
 */
public final class LogSlf4jExample {

    /**
     * Logger by slf4j.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);

    /**
     * String for testing.
     */
    private static String one = "One";

    /**
     * One more string for testing.
     */
    private static String two = "Two";

    /**
     * Simple string.
     */
    private static String simple = "My string";

    /**
     * String for string format.
     */
    private static String complex = "My string and %s and %s";

    /**
     * String for string format.
     */
    private static String complexslf = "My string and {} and {}";

    /**
     * Private contructor.
     */
    private LogSlf4jExample() {
    }

    /**
     * Bad example of logging.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void badExample() {
        if (LogSlf4jExample.LOGGER.isTraceEnabled()) {
            LogSlf4jExample.LOGGER.trace(LogSlf4jExample.simple);
        }
        if (LogSlf4jExample.LOGGER.isTraceEnabled()) {
            LogSlf4jExample.LOGGER.trace(
                String.format(
                    LogSlf4jExample.complex,
                    LogSlf4jExample.one,
                    LogSlf4jExample.two
                ));
        }
    }

    /**
     * Good example of logging.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void goodExample() {
        LogSlf4jExample.LOGGER.trace(LogSlf4jExample.simple);
        LogSlf4jExample.LOGGER.trace(
            LogSlf4jExample.complexslf,
            LogSlf4jExample.one,
            LogSlf4jExample.two
        );
    }
}
