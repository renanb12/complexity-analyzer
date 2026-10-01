package br.com.complexityanalyzer;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import br.com.complexityanalyzer.algorithm.implementations.ArrayTraversal;
import br.com.complexityanalyzer.analysis.AnalysisResult;
import br.com.complexityanalyzer.analysis.ComplexityAnalyzer;
import br.com.complexityanalyzer.analysis.ExecutionResult;
import br.com.complexityanalyzer.chart.ChartGenerator;
import br.com.complexityanalyzer.generator.implementations.RandomIntegerArrayGenerator;

public class App{
    public static void main(String[] args) {
        ArrayTraversal arrayTraversal = new ArrayTraversal();
        RandomIntegerArrayGenerator random = new RandomIntegerArrayGenerator();

        ComplexityAnalyzer<int[]> complexityAnalyzer = new ComplexityAnalyzer<int[]>(arrayTraversal, random);

        AnalysisResult result = complexityAnalyzer.analyze(100, 1000, 100);

        System.out.println("Algorithm: " + result.getAlgorithmName());
        System.out.println("n\tOperations\tTime (ns)");

        for (ExecutionResult execution : result.getExecutionResults()) {
            System.out.println(
            execution.getInputSize() + "\t" +
            execution.getOperationCount() + "\t\t" +
            execution.getExecutionTime()
            );
        }

        ChartGenerator chartGenerator = new ChartGenerator();

        XYChart chart = chartGenerator.generateOperationsChart(result);
        new SwingWrapper<>(chart).displayChart();

        XYChart chartexecutionTime = chartGenerator.generateExecutionTimeChart(result);
        new SwingWrapper<>(chartexecutionTime).displayChart();
    }
}
