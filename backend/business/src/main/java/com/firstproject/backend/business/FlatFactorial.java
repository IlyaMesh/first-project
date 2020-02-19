/*
 * Copyright
 */

package com.firstproject.backend.business;

import org.springframework.stereotype.Component;

/**
 * Check factorial using cycle.
 *
 * @since 0.0.1
 */
@Component
public class FlatFactorial implements Factorial {
    @Override
    public final int calculate(final int value) {
        int result = 1;
        for (int idx = 1; idx <= value; ++idx) {
            result = result * idx;
        }
        return result;
    }

    @Override
    public final boolean canApply(final int value) {
        final int less = 5;
        return value < less;
    }
}
