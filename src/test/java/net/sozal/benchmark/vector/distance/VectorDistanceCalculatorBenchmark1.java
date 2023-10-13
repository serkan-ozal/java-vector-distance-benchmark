package net.sozal.benchmark.vector.distance;

import net.sozal.benchmark.vector.distance.impl.SimpleVectorDistanceCalculator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author sozal
 */
@BenchmarkMode(Mode.Throughput)
@Fork(value = 3)
@Warmup(time = 5, iterations = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(time = 30, iterations = 5, timeUnit = TimeUnit.SECONDS)
public class VectorDistanceCalculatorBenchmark1 {

    @State(Scope.Benchmark)
    public static class BenchmarkState {

        static final int VECTOR_LENGTH = 1000;

        float[] v1 = new float[VECTOR_LENGTH];
        float[] v2 = new float[VECTOR_LENGTH];

        VectorDistanceCalculator simple = new SimpleVectorDistanceCalculator();

        @Setup
        public void setup() {
            Random random = new Random();

            for (int i = 0; i < VECTOR_LENGTH; i++) {
                v1[i] = random.nextFloat();
                v2[i] = random.nextFloat();
            }
        }

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(VectorDistanceCalculatorBenchmark1.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void cosineSimilaritySimple(BenchmarkState state, Blackhole bh) {
        double distance = state.simple.cosineSimilarity(state.v1, state.v2);
        bh.consume(distance);
    }

    @Benchmark
    public void dotProductSimple(BenchmarkState state, Blackhole bh) {
        double distance = state.simple.dotProduct(state.v1, state.v2);
        bh.consume(distance);
    }

    @Benchmark
    public void manhattanDistanceSimple(BenchmarkState state, Blackhole bh) {
        double distance = state.simple.manhattanDistance(state.v1, state.v2);
        bh.consume(distance);
    }

    @Benchmark
    public void euclideanDistanceSimple(BenchmarkState state, Blackhole bh) {
        double distance = state.simple.euclideanDistance(state.v1, state.v2);
        bh.consume(distance);
    }

}
