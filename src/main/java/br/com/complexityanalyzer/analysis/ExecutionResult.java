package br.com.complexityanalyzer.analysis;

public class ExecutionResult {
    private int inputSize;
    private long executionTime;
    private long operationCount;

    public ExecutionResult(int inputSize, long operationCount, long executionTime){
        this.inputSize = inputSize;
        this.operationCount = operationCount;
        this.executionTime = executionTime;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public int getInputSize() {
        return inputSize;
    }

    public long getOperationCount() {
        return operationCount;
    }
}
