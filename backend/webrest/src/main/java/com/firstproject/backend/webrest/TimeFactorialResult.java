/*
 * Copyright
 */

package com.firstproject.backend.webrest;

import com.firstproject.backend.model.FactorialResults;
import java.util.Date;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Extened class which extends with time of creation.
 *
 * @since 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Primary
public class TimeFactorialResult extends FactorialResults {

    /**
     * Creation date.
     */
    private final Date date;

    /**
     * Constuctor.
     *
     * @param value Value.
     * @param method Method.
     */
    public TimeFactorialResult(final int value, final String method) {
        super(value, method);
        this.date = new Date();
    }

    /**
     * Return date of creatin object.
     * @return Date to string representation.
     */
    public final String getCreation() {
        return this.date.toString();
    }
}
