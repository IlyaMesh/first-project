/*
 * Copyright
 */

package com.firstproject.testmodule;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

/**
 * My favorite class.
 * Using for check how to work with Maven and Qulice.
 *
 * @since 0.0.1
 */
public final class HelloWorld {

    /**
     * Logger for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class);

    /**
     * Private constructor for prohibit to create an instance of this class.
     */
    private HelloWorld() {
    }

    /**
     * Entry point into the application.
     * Create a message and make a fake array which check to empty and display results.
     *
     * @param args Arguments.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void main(final String[] args) {
        HelloWorld.LOGGER.trace("Hello World!");
        final List<String> collection = Lists.newArrayList(
            "OneString",
            "TwoString",
            "TreeString"
        );
        if (CollectionUtils.isNotEmpty(collection)) {
            HelloWorld.LOGGER.trace("Collection is not empty!");
        } else {
            HelloWorld.LOGGER.trace("Collection is empty");
        }
        Log4JExample.badExample();
        Log4JExample.goodExample();
        LogSlf4jExample.badExample();
        LogSlf4jExample.goodExample();
    }
}
