/*
 * Copyright
 */

package com.firstproject.test;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Benchmark example.
 * <p>
 * Here you can test different code.
 *
 * @since 0.0.1
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(LogSlf4jTest.FORK)
@Warmup(iterations = LogSlf4jTest.WARMUP)
@Measurement(iterations = LogSlf4jTest.MEASUREMENT)
public class LogSlf4jTest {

    /**
     * Fork number.
     */
    static final int FORK = 2;

    /**
     * Fork number.
     */
    static final int WARMUP = 2;

    /**
     * Fork number.
     */
    static final int MEASUREMENT = 2;

    /**
     * Logger variable.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LogSlf4jTest.class);

    /**
     * Main method. Launch a benchmark.
     *
     * @throws RunnerException Can't run a test.
     * @deprecated Not using in build test.
     */
    @Test
    @Deprecated
    public void run() throws RunnerException {
        final Options opt = new OptionsBuilder()
            .include(LogSlf4jTest.class.getSimpleName())
            .forks(1)
            .build();
        new Runner(opt).run();
    }

    /**
     * Test logger without if statuement.
     *
     * @param blackhole Blackhole instance.
     */
    @Benchmark
    @SuppressWarnings("PMD.JUnit4TestShouldUseTestAnnotation")
    public final void testWithoutIf(final Blackhole blackhole) {
        LogSlf4jTest.LOGGER.trace(
            "My message without if ! {} {} {}", "If", "IF", "iF"
        );
        blackhole.consume("1");
    }

    /**
     * Test logger with if statuement.
     *
     * @param blackhole Blackhole instance.
     */
    @Benchmark
    @SuppressWarnings("PMD.JUnit4TestShouldUseTestAnnotation")
    public final void testWithIf(final Blackhole blackhole) {
        if (LogSlf4jTest.LOGGER.isTraceEnabled()) {
            LogSlf4jTest.LOGGER.trace(
                "My message with if ! {} {} {}", "WithoutIf", "WithoutIF", "WithoutiF"
            );
        }
        blackhole.consume("1");
    }
}
