package br.com.complexityanalyzer.chart;

import java.util.List;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import br.com.complexityanalyzer.analysis.AnalysisResult;
import br.com.complexityanalyzer.analysis.ExecutionResult;

public class ChartGenerator {

    public XYChart generateOperationsChart(AnalysisResult analysisResult){
        List<ExecutionResult> results = analysisResult.getExecutionResults();
        int size = results.size();

        double[] dataX = new double[size];
        double[] dataY = new double[size];

        for (int i = 0; i < size; i++) {
            ExecutionResult execution = results.get(i);

            dataX[i] = execution.getInputSize();
            dataY[i] = execution.getOperationCount();
        }

        XYChart chart = new XYChartBuilder()
            .width(800)
            .height(600)
            .title(analysisResult.getAlgorithmName())
            .xAxisTitle("Input Size")
            .yAxisTitle("Operations")
            .build();

            chart.addSeries("Operations", dataX, dataY);
            
            return chart;
    }

    public XYChart generateExecutionResult(AnalysisResult analysisResult){
        List<ExecutionResult> results = analysisResult.getExecutionResults();
        int size = results.size();

        double[] dataX = new double[size];
        double[] dataY = new double[size];

        for (int i = 0; i < size; i++) {
            ExecutionResult execution = results.get(i);

            dataX[i] = execution.getInputSize();
            dataY[i] = execution.getExecutionTime();
        }

        XYChart chart = new XYChartBuilder()
            .width(800)
            .height(600)
            .title(analysisResult.getAlgorithmName())
            .xAxisTitle("Input Size")
            .yAxisTitle("execution Time")
            .build();

            chart.addSeries("Execution Time", dataX, dataY);
            
            return chart;
    }
}
