package br.com.complexityanalyzer.regression;

public class RegressionResult {
    private RegressionModel model;
    private double slope;
    private double intercept;
    private double rSquared;
    private double mse;

    public RegressionResult(RegressionModel model, double slope, double intercept, double rSquared, double mse){
        this.model = model;
        this.slope = slope;
        this.intercept = intercept;
        this.rSquared = rSquared;
        this.mse = mse;
    }

    public RegressionModel getModel() {
        return model;
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    public double getRSquared() {
        return rSquared;
    }

    public double getMse() {
        return mse;
    }

}
