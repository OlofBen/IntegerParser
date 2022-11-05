package integerparser.graph;

public class Constatnt implements Graphable{

    private double value; 

    public Constatnt(double value) {
        this.value = value;
    }

    public void setValue(double value){
        this.value = value;
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
    public void setDirivative(double dirivative) {}
    
}
