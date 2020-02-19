/*
 * Copyright
 */

package com.firstproject.testmodule;

import org.apache.log4j.Logger;

/**
 * Class for check logger functional.
 *
 * @since 0.0.1
 */
public final class Log4JExample {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(Log4JExample.class);

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
     * Private contructor.
     */
    private Log4JExample() {
    }

    /**
     * Bad example of logging.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void badExample() {
        if (Log4JExample.LOGGER.isTraceEnabled()) {
            Log4JExample.LOGGER.trace(Log4JExample.simple);
        }
        Log4JExample.LOGGER.trace(
            String.format(
                Log4JExample.complex,
                Log4JExample.one,
                Log4JExample.two
            ));
    }

    /**
     * Good example of logging.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void goodExample() {
        Log4JExample.LOGGER.trace(Log4JExample.simple);
        if (Log4JExample.LOGGER.isTraceEnabled()) {
            Log4JExample.LOGGER.trace(
                String.format(
                    Log4JExample.complex,
                    Log4JExample.one,
                    Log4JExample.two
                ));
        }
    }
}
