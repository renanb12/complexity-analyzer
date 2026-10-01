package br.com.complexityanalyzer.algorithm;

public interface Algorithm<T> {

    long execute(T data);

    String getName();
}