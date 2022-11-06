package integerparser.network.graph;

public class Variable implements Changeable{

    public static double weightInitValue = 1;
    public static double biasInitValue = 1;

    private double value;
    private double dirivative = 0;

    public Variable(double value) {
        this.value = value;
    }

    @Override
    public void changeOppositeGradient(double stepSize){
        value -= dirivative * stepSize;
        dirivative = 0;
    }

    @Override
    public double value() {
        return value;
    }

    @Override
    public void reset() {}

    @Override
    public void dirive() {}

    @Override
    public void setDirivative(double dirivative) {
        this.dirivative += dirivative;      
    } 
}
