package org.uma.mbd.mdAlturasV3.alturas;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MiColector implements Collector<String, Set<String>, TreeSet<String>> {
    public Supplier<Set<String>> supplier() {
        return HashSet::new;
    }
    public BiConsumer<Set<String>, String> accumulator() {
        return Set::add;
    }
    public BinaryOperator<Set<String>> combiner() {
        return (s1,s2) ->{s1.addAll(s2); return s1;};
    }
    public Function<Set<String>, TreeSet<String>> finisher() {
        return TreeSet::new;
    }
    public Set<Collector.Characteristics> characteristics() {
        return new HashSet<Characteristics>(
                Arrays.asList(Characteristics.CONCURRENT,
                        Characteristics.UNORDERED));
    }
}
