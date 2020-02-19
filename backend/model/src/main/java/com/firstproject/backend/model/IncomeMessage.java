/*
 * Copyright
 */

package com.firstproject.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple class for keep a messages.
 *
 * @since 0.0.1
 */
public class IncomeMessage {
    /**
     * Just message.
     */
    private final String message;

    /**
     * Just message.
     */
    private final Integer value;

    /**
     * Constructor with parameters.
     * @param message Message.
     * @param value Value.
     */
    @JsonCreator
    public IncomeMessage(
        @JsonProperty("message") final String message,
        @JsonProperty("value") final Integer value) {
        this.message = message;
        this.value = value;
    }

    /**
     * Just message.
     *
     * @return Message.
     */
    public final String getMessage() {
        return this.message;
    }

    /**
     * Just value.
     *
     * @return Value.
     */
    public final Integer getValue() {
        return this.value;
    }
}
