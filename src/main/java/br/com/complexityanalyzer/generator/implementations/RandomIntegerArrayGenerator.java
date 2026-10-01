package br.com.complexityanalyzer.generator.implementations;

import br.com.complexityanalyzer.generator.DataGenerator;

public class RandomIntegerArrayGenerator implements DataGenerator<int[]> {
    @Override
    public int[] generate(int size) {
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = (int)(Math.random() * 101);
        }
        return data;
    }
}
