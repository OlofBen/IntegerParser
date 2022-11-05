package integerparser.graph;

public class Variable implements Graphable{

    private double value;
    private double dirivative = 0;

    public Variable(double value) {
        this.value = value;
    }

    public void changeBasedOnDirivative(double stepSize){
        value += dirivative * stepSize;
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
