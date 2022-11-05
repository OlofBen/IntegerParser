package integerparser.graph;

import java.util.*;

public class Node implements Graphable, Changeable{

    private List<Edge> edges;
    private Variable bias;
    private double value;
    private double dirivative = 0; 
    private boolean hasCalculated = false;
    //TODO minimizing funktion e.g. sigmoid

    public Node(List<Graphable> incoming) {
        edges = new LinkedList<>();
        bias = new Variable(Variable.biasInitValue);
        incoming.forEach(
            in -> edges.add(new Edge(in))
        );
    }

    @Override
    public double value() {
        return hasCalculated ? value : calculate();
    }

    private double calculate(){
        hasCalculated = true;
        value = 
            edges.stream()
            .mapToDouble(e -> e.value())
            .sum();
        value += bias.value();
        return value;
    }

    @Override
    public void reset() {
        hasCalculated = false;
        dirivative = 0;
        edges.forEach(e -> e.reset());    
    }

    @Override
    public void dirive() {
        edges.forEach(e -> e.setDirivative(dirivative));
        bias.setDirivative(dirivative);        
    }

    @Override
    public void setDirivative(double dirivative) {
        this.dirivative += dirivative;        
    }

    @Override
    public void changeBasedOnDirivative(double stepSize) {
        edges.forEach(e -> changeBasedOnDirivative(stepSize));
        bias.changeBasedOnDirivative(stepSize);        
    }
    
}
