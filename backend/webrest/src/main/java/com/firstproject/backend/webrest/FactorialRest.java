/*
 * Copyright
 */

package com.firstproject.backend.webrest;

import com.firstproject.backend.business.Factorial;
import com.firstproject.backend.business.FlatFactorial;
import com.firstproject.backend.business.RecursiveFactorial;
import com.firstproject.backend.model.FactorialRequest;
import com.firstproject.backend.model.FactorialResults;
import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest services for calculation factorial.
 *
 * @since 0.0.1
 */
@RestController
@RequestMapping("factorial")
public class FactorialRest {

    /**
     * Exception message about absent calculator.
     */
    private static final String MESSAGE = "Can't find a right factorial calculator";

    /**
     * Collection of factorials.
     */
    private final List<Factorial> factorials;

    /**
     * Object provider for results.
     */
    private final ObjectProvider<FactorialResults> provider;

    /**
     * Default contructor.
     *
     * @param factorials List if factorials calculators.
     * @param provider Object provider for new entity.
     */
    @Autowired
    public FactorialRest(
        final List<Factorial> factorials,
        final ObjectProvider<FactorialResults> provider) {
        this.factorials = factorials;
        this.provider = provider;
    }

    /**
     * Calculate flat factorial.
     * @param value Value by path variable
     * @return Factorial results.
     */
    @GetMapping("/flat/{value}")
    @CrossOrigin
    public FactorialResults flat(@PathVariable final Integer value) {
        for (final Factorial factorial : this.factorials) {
            if (factorial.getClass().isAssignableFrom(FlatFactorial.class)) {
                return this.provider.getObject(
                    factorial.calculate(value),
                    factorial.getClass().getSimpleName()
                );
            }
        }
        throw new UnsupportedOperationException(FactorialRest.MESSAGE);
    }

    /**
     * Calculate requesive factorial.
     * @param value Value by Query params.
     * @return Factorial results.
     */
    @GetMapping("/recursive")
    @CrossOrigin
    public FactorialResults recursive(@RequestParam final Integer value) {
        for (final Factorial factorial : this.factorials) {
            if (factorial.getClass().isAssignableFrom(RecursiveFactorial.class)) {
                return this.provider.getObject(
                    factorial.calculate(value),
                    factorial.getClass().getSimpleName()
                );
            }
        }
        throw new UnsupportedOperationException(FactorialRest.MESSAGE);
    }

    /**
     * Calculate factorial using autodefine.
     * @param request Request factorial
     * @return Factorial results.
     */
    @PostMapping("/auto")
    @CrossOrigin
    public FactorialResults auto(@RequestBody final FactorialRequest request) {
        for (final Factorial factorial : this.factorials) {
            if (factorial.canApply(request.getValue())) {
                return this.provider.getObject(
                    factorial.calculate(request.getValue()),
                    factorial.getClass().getSimpleName()
                );
            }
        }
        throw new UnsupportedOperationException(FactorialRest.MESSAGE);
    }
}
