package br.com.complexityanalyzer.regression;

public enum RegressionModel {
    CONSTANT {
        @Override
        public double transform(double n) {
            return 1;
        }
    },
    LOGARITHMIC {
        @Override
        public double transform(double n) {
            return Math.log(n);
        }
    },
    LINEAR {
        @Override
        public double transform(double n) {
            return n;
        }
    },
    N_LOG_N {
        @Override
        public double transform(double n) {
            return n * Math.log(n);
        }
    },
    QUADRATIC {
        @Override
        public double transform(double n) {
            return Math.pow(n, 2);
        }
    },
    CUBIC {
        @Override
        public double transform(double n) {
            return Math.pow(n, 3);
        }
    };

    public abstract double transform(double n);
}
