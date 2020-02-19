/*
 * Copyright
 */

package com.firstproject.backend.webrest;

import com.firstproject.backend.business.Factorial;
import com.firstproject.backend.model.FactorialResults;
import com.firstproject.backend.model.IncomeMessage;
import java.util.List;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest implementation of controller.
 *
 * @since 0.0.1
 */
@RestController
@RequestMapping("test")
public class MessageRest implements MessageController {

    /**
     * Field for calculate factorial.
     */
    private final Factorial factorial;

    /**
     * List of factorials.
     */
    private final List<Factorial> factorials;

    /**
     * Results object provider.
     */
    private final ObjectProvider<FactorialResults> provider;

    /**
     * Default contructor.
     *
     * @param factorial Factorial calculator instance.
     * @param factorials List if factorials calculators.
     * @param provider Object provider for new entity.
     */
    @Autowired
    public MessageRest(
        @Qualifier("flatFactorial") final Factorial factorial,
        final List<Factorial> factorials,
        final ObjectProvider<FactorialResults> provider) {
        this.factorial = factorial;
        this.factorials = factorials;
        this.provider = provider;
    }

    @GetMapping("/message")
    @Override
    public final String getMessage() {
        return "My first string!";
    }

    @GetMapping("/factorial")
    @Override
    public final int getFactorial() {
        final int defaultval = 5;
        return this.factorial.calculate(defaultval);
    }

    @GetMapping("/smartFactorial")
    @Override
    public final int smartFactorial() {
        final int defaultval = 5;
        int ret = 0;
        for (final Factorial fact : this.factorials) {
            if (fact.canApply(defaultval)) {
                ret = fact.calculate(defaultval);
                break;
            }
        }
        return ret;
    }

    @GetMapping("/factorialInform")
    @Override
    public final FactorialResults withInformation(@RequestParam final int value) {
        FactorialResults results = null;
        for (final Factorial fact : this.factorials) {
            if (fact.canApply(value)) {
                results = this.provider.getObject(
                    fact.calculate(value),
                    fact.getClass().getSimpleName()
                );
                break;
            }
        }
        return results;
    }

    @PostMapping("/factorialString")
    @Override
    public final String withInformation(@RequestBody final IncomeMessage message) {
        return String.format(
            "%s %d",
            message.getMessage(),
            this.factorial.calculate(message.getValue())
        );
    }
}
