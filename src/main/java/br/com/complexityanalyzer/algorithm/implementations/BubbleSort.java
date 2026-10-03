package br.com.complexityanalyzer.algorithm.implementations;

import br.com.complexityanalyzer.algorithm.Algorithm;

public class BubbleSort implements Algorithm<int[]> {

    @Override
    public long execute(int[] data) {
        long operationCount = 0;

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                operationCount++;

                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        return operationCount;
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
