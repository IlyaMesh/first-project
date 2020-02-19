/*
 * Copyright
 */

package com.firstproject.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * For factorial results.
 *
 * @since 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FactorialResults {

    /**
     * Result of factorial.
     */
    private final int value;

    /**
     * Calculating method.
     */
    private final String method;

    /**
     * Constuctor.
     * @param value Value.
     * @param method Method.
     */
    @JsonCreator
    public FactorialResults(
        @JsonProperty("value") final int value,
        @JsonProperty("method") final String method
    ) {
        this.value = value;
        this.method = method;
    }

    /**
     * Result of factorial.
     *
     * @return Result of factorial.
     */
    public final int getValue() {
        return this.value;
    }

    /**
     * Calculating method.
     *
     * @return Method name.
     */
    public final String getMethod() {
        return this.method;
    }

}
