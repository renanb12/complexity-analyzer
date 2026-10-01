package br.com.complexityanalyzer.algorithm.implementations;

import br.com.complexityanalyzer.algorithm.Algorithm;

public class ArrayTraversal implements Algorithm<int[]> {

    @Override
    public long execute(int[] data) {
        long operationCount = 0;

        for (int value : data) {
            operationCount++;
        }

        return operationCount;
    }

    @Override
    public String getName() {
        return "Array Traversal";
    }
}