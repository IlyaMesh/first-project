/*
 * Copyright
 */

package com.firstproject.backend.webrest;

import com.firstproject.backend.model.FactorialResults;
import com.firstproject.backend.model.IncomeMessage;

/**
 * Interface for implement return of simple message.
 *
 * @since 0.0.1
 */
public interface MessageController {

    /**
     * Return simple message.
     * @return Some string.
     */
    String getMessage();

    /**
     * Calculate factorical.
     * @return Results.
     */
    int getFactorial();

    /**
     * Calculate factorial according to value.
     * @return Results.
     */
    int smartFactorial();

    /**
     * Calculate with additional information.
     *
     * @param value Value for calculating.
     * @return Entity.
     */
    FactorialResults withInformation(int value);

    /**
     * Calculate factorial and return it as string.
     * @param message Message with factorial val.
     * @return Calculated value with message.
     */
    String withInformation(IncomeMessage message);
}
