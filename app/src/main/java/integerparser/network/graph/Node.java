package integerparser.network.graph;

import java.util.*;

public class Node extends Calculable{

    private List<Edge> edges;
    private Variable bias;
    //TODO minimizing funktion e.g. sigmoid

    public Node(List<Graphable> incoming) {
        super();
        edges = new LinkedList<>();
        bias = new Variable(Variable.biasInitValue);
        incoming.forEach(
            in -> edges.add(new Edge(in))
        );
    }

    @Override
    protected double calculate(){
        var value = 
            edges.stream()
            .mapToDouble(e -> e.value())
            .sum();
        value += bias.value();
        return value;
        
    }

    @Override
    public void dirive() {
        edges.forEach(e -> e.setDirivative(dirivative));
        bias.setDirivative(dirivative);        
    }

    @Override
    protected void resetComponentes() {
        edges.forEach(e -> e.reset());          
    }

    @Override
    protected void oppositeGradient(double stepSize) {
        edges.forEach(e -> changeOppositeGradient(stepSize));
        bias.changeOppositeGradient(stepSize);          
    }  
}
