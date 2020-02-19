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
 * For request calculation of factorial.
 *
 * @since 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FactorialRequest {

    /**
     * Need to calculate for.
     */
    private final int value;

    /**
     * Constuctor.
     * @param value Value.
     */
    @JsonCreator
    public FactorialRequest(@JsonProperty("value") final int value) {
        this.value = value;
    }

    /**
     * Value for calculation.
     *
     * @return Result of factorial.
     */
    public final int getValue() {
        return this.value;
    }
}
