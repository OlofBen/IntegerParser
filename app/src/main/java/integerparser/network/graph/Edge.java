package integerparser.network.graph;

public class Edge extends Calculable{

    private Variable weight;
    private Graphable child;

    public Edge(Graphable child) {
        this.child = child;

        weight = new Variable(Variable.weightInitValue());

    }
    
    public Edge(Graphable child, double weight) {
        this.weight = new Variable(weight);
        this.child = child;
    }

    @Override
    protected double calculate() {
        return child.value() * weight.value();
    }

    @Override
    public void dirive() {
        weight.setDirivative(dirivative * child.value());  
        child.setDirivative(dirivative * weight.value());      
    }

    @Override
    public void setDirivative(double dirivative) {
        this.dirivative += dirivative;       
    }

    @Override
    protected void resetComponentes() {}

    @Override
    protected void oppositeGradient(double stepSize) {
        weight.changeOppositeGradient(stepSize);        
    }
    
}
