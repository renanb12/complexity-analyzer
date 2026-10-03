package br.com.complexityanalyzer.algorithm.implementations;

import br.com.complexityanalyzer.algorithm.Algorithm;

public class ConstantAlgorithm implements Algorithm<int[]> {

    @Override
    public long execute(int[] data) {
        long operationCount = 0;

        // Simula sempre exatamente 5 operações,
        // independentemente do tamanho da entrada.
        for (int i = 0; i < 5; i++) {
            operationCount++;
        }

        return operationCount;
    }

    @Override
    public String getName() {
        return "Constant Algorithm";
    }
}
