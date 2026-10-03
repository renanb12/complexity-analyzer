package br.com.complexityanalyzer.regression.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import br.com.complexityanalyzer.analysis.AnalysisResult;
import br.com.complexityanalyzer.analysis.ExecutionResult;
import br.com.complexityanalyzer.regression.RegressionModel;
import br.com.complexityanalyzer.regression.RegressionResult;

public class RegressionAnalyzer {
    public RegressionResult analyze(AnalysisResult analysisResult, RegressionModel model){
        SimpleRegression regression = new SimpleRegression();
        
        List<ExecutionResult> executionResults = analysisResult.getExecutionResults();
        
        for (ExecutionResult execution : executionResults) {
            long n = execution.getInputSize();
            regression.addData(
                model.transform(n),
                execution.getOperationCount()
            );
        }

        double slope = regression.getSlope();
        double intercept = regression.getIntercept();
        double mse = getMse(analysisResult, model, slope, intercept);
        RegressionResult result = new RegressionResult(model, slope, intercept, regression.getRSquare(), mse);
        return result;
    }

    public List<RegressionResult> analyzeAll(AnalysisResult analysisResult){
        List<RegressionResult> regressionResults = new ArrayList<>();

        for (RegressionModel model : RegressionModel.values()) {
            if (model != RegressionModel.CONSTANT) {
                regressionResults.add(analyze(analysisResult, model));
            } else {
                regressionResults.add(analyzeConstant(analysisResult));
            }
        }

        return regressionResults;
    }

    public RegressionResult findBestModel(List<RegressionResult> regressionResults){
        RegressionResult best = regressionResults.get(0);

        for (RegressionResult result : regressionResults) {
            if (best.getMse() > result.getMse()) {
                best = result;
            }
        }

        return best;
    }

    public RegressionResult analyzeConstant(AnalysisResult analysisResult) {
        List<ExecutionResult> executionResults = analysisResult.getExecutionResults();

        double sum = 0;

        for (ExecutionResult executionResult : executionResults) {
            sum += executionResult.getOperationCount();
        }

        double mean = sum / executionResults.size();
        double squaredErrorSum = 0;
        
        for (ExecutionResult executionResult : executionResults) {
            double error = executionResult.getOperationCount() - mean;
            squaredErrorSum += Math.pow(error, 2);
        }

        double mse = squaredErrorSum / executionResults.size();

        RegressionResult regressionResult = new RegressionResult(RegressionModel.CONSTANT, 0, mean, Double.NaN, mse);
        return regressionResult;
    }

    public double getMse(AnalysisResult analysisResult, RegressionModel model, double slope, double intercept) {
        List<ExecutionResult> executionResults = analysisResult.getExecutionResults();
        double squaredErrorSum = 0;

        for (ExecutionResult executionResult : executionResults) {
            double n = executionResult.getInputSize();
            double x = model.transform(n);
            double predicted = slope * x + intercept;

            double error = executionResult.getOperationCount() - predicted;
            squaredErrorSum += Math.pow(error, 2);
        }

        double mse = squaredErrorSum / executionResults.size();

        return mse;
    }
}
