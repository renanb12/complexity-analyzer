package br.com.complexityanalyzer;

import java.util.List;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import br.com.complexityanalyzer.algorithm.Algorithm;
import br.com.complexityanalyzer.algorithm.implementations.ArrayTraversal;
import br.com.complexityanalyzer.algorithm.implementations.BubbleSort;
import br.com.complexityanalyzer.algorithm.implementations.ConstantAlgorithm;
import br.com.complexityanalyzer.analysis.AnalysisResult;
import br.com.complexityanalyzer.analysis.ComplexityAnalyzer;
import br.com.complexityanalyzer.analysis.ExecutionResult;
import br.com.complexityanalyzer.chart.ChartGenerator;
import br.com.complexityanalyzer.generator.DataGenerator;
import br.com.complexityanalyzer.generator.implementations.RandomIntegerArrayGenerator;
import br.com.complexityanalyzer.regression.RegressionResult;
import br.com.complexityanalyzer.regression.implementations.RegressionAnalyzer;

public class App{
    public static void main(String[] args) {

        DataGenerator<int[]> generator = new RandomIntegerArrayGenerator();

        testAlgorithm(new ConstantAlgorithm(), generator);
        testAlgorithm(new ArrayTraversal(), generator);
        testAlgorithm(new BubbleSort(), generator);
    }

    private static void testAlgorithm(
        Algorithm<int[]> algorithm,
        DataGenerator<int[]> generator
    ) {

        ComplexityAnalyzer<int[]> complexityAnalyzer =
            new ComplexityAnalyzer<>(algorithm, generator);

        AnalysisResult analysisResult =
            complexityAnalyzer.analyze(100, 1000, 100);

        RegressionAnalyzer regressionAnalyzer =
            new RegressionAnalyzer();

        List<RegressionResult> results =
            regressionAnalyzer.analyzeAll(analysisResult);

        System.out.println("\n==============================");
        System.out.println("Algorithm: " + analysisResult.getAlgorithmName());
        System.out.println("==============================");

        for (RegressionResult result : results) {

            System.out.println("\nModel: " + result.getModel());
            System.out.println("R²: " + result.getRSquared());
            System.out.println("MSE: " + result.getMse());
        }

        RegressionResult best =
            regressionAnalyzer.findBestModel(results);

        System.out.println("\n--- BEST MODEL ---");
        System.out.println("Model: " + best.getModel());
        System.out.println("MSE: " + best.getMse());
    }
}
