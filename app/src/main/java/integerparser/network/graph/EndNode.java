package integerparser.network.graph;

public class EndNode extends Calculable{

    private Constatnt expected;
    private Graphable incoming;

    public EndNode(Graphable incoming) {
        this.incoming = incoming;
        expected = new Constatnt(0);
    }

    public void setExpected(double value) {
        reset();
        expected.setValue(value);
    }

    @Override
    protected double calculate() {
        var sum = expected.value() - incoming.value();
        return sum * sum;
    }

    @Override
    protected void resetComponentes() {}

    @Override
    public void dirive() {
        incoming.setDirivative(
            -2*(expected.value() - incoming.value())

        );
    }

    @Override
    protected void oppositeGradient(double stepSize) {}

    @Override
    public void setDirivative(double dirivative) {
        throw new UnsupportedOperationException();
    }
    
}
