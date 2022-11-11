package integerparser.util.math;

public class Sigmoid implements Funk{

    @Override
    public double value(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    @Override
    public double dirivative(double valueOfCalculatedFunction) {
        return valueOfCalculatedFunction * (1 - valueOfCalculatedFunction);
    }
    
}
