package br.com.complexityanalyzer.analysis;
import java.util.ArrayList;
import java.util.List;

public class AnalysisResult {
    private String algorithmName;
    private List<ExecutionResult> executionResults;
    
    public AnalysisResult(String algorithmName){
        this.algorithmName = algorithmName;
        this.executionResults = new ArrayList<>();
    }

    public void add(ExecutionResult executionResult){
        executionResults.add(executionResult);
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }
}
