package integerparser.network.graph;

public class EndNode extends Calculable{

    private Constatnt expected;
    private Node incoming;

    @Override
    protected double calculate() {
        var sum = expected.value() - incoming.value();
        return sum * sum;
    }

    @Override
    protected void resetComponentes() {}

    @Override
    public void dirive() {
        incoming.setDirivative(dirivative);       
    }

    @Override
    protected void oppositeGradient(double stepSize) {}

    @Override
    public void setDirivative(double dirivative) {
        throw new UnsupportedOperationException();
    }
    
}
