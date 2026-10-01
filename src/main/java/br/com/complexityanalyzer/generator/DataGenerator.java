package br.com.complexityanalyzer.generator;

public interface DataGenerator<T> {
    T generate(int size);
}
