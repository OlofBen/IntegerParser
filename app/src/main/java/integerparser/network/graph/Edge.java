package integerparser.network.graph;

public class Edge implements Changeable{

    private boolean hasCalculated = false;
    private Variable weight;
    private Graphable child;
    private double value;
    private double dirivative;

    public Edge(Graphable child) {
        this.child = child;
        weight = new Variable(Variable.weightInitValue);
    }
    
    public Edge(Graphable child, double weight) {
        this.weight = new Variable(weight);
        this.child = child;
    }

    @Override
    public double value() {
        return hasCalculated ? value : calculate();
    }

    private double calculate() {
        hasCalculated = true; 
        value = child.value() * weight.value();
        return value;
    }

    @Override
    public void reset() {
        hasCalculated = false;
        dirivative = 0;
                
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
    public void changeOppositeGradient(double stepSize) {
        weight.changeOppositeGradient(stepSize);        
    }
    
}
