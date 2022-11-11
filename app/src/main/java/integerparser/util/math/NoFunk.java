package integerparser.util.math;

public class NoFunk implements Funk {

    @Override
    public double value(double x) {
        return x;
    }

    @Override
    public double dirivative(double valueOfCalculatedFunction) {
        // TODO Auto-generated method stub
        return 1;
    }
    
}
