package br.com.complexityanalyzer.analysis;

import br.com.complexityanalyzer.algorithm.Algorithm;
import br.com.complexityanalyzer.generator.DataGenerator;

public class ComplexityAnalyzer<T> {
    private final Algorithm<T> algorithm;
    private final DataGenerator<T> dataGenerator;
    
    public ComplexityAnalyzer(Algorithm<T> algorithm, DataGenerator<T> dataGenerator){
        this.algorithm = algorithm;
        this.dataGenerator = dataGenerator;
    }

    public AnalysisResult analyze(int startSize, int endSize, int stepSize){
        if (stepSize <= 0){
            throw new IllegalArgumentException("Set a step size greater than 0.");
        }

        if (startSize <= 0 ){
            throw new IllegalArgumentException("Set a start size greater than 0.");
        }

        if ( endSize < startSize ){
            throw new IllegalArgumentException("Set an end size larger than the start size.");
        }

        AnalysisResult analysisResult = new AnalysisResult(algorithm.getName());
        int currentSize = startSize;
        long startTime;
        long endTime;
        long operationCount;
        while (currentSize <= endSize) {
            T data = dataGenerator.generate(currentSize);

            startTime = System.nanoTime();
            operationCount = algorithm.execute(data);
            endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            ExecutionResult executionResult = new ExecutionResult(currentSize, operationCount, executionTime);
            analysisResult.add(executionResult);
            
            currentSize += stepSize;
        }
        
        return analysisResult;
    }
}
