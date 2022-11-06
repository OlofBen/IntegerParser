package integerparser.network;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import integerparser.network.graph.*;

public class GraphNetwork implements ImprovableNetwork {

    private List<Constatnt> input;
    private List<List<Node>> nodes;
    //How to do the final row.
 
    public static ImprovableNetwork load(){
        throw new UnsupportedOperationException();
    }

    public GraphNetwork(List<Integer> size) {
        input = new LinkedList<>();
        rowZero(size);
        nodes = new LinkedList<>();
        rowOne(size);
        rowRest(size);
    }

    private void rowZero(List<Integer> size) {
        for(int i = 0; i<size.get(0); i++){
            input.add(new Constatnt(0));
        }
    }

    private void rowOne(List<Integer> size) {
        var inputAsGraphable = variableToGraphable(input);
        nodes.add(new LinkedList<>());
        for(int index = 0; index<size.get(1); index++){
            nodes.get(0).add(new Node(inputAsGraphable));
        }
    }

    private void rowRest(List<Integer> size) {
        for (int row = 2; row<size.size(); row++){
            nodes.add(new LinkedList<>());
            var in = toNodeGraphable(nodes.get(row-2));
            for(int index = 0; index<size.get(row); index++){
                nodes.get(row - 1).add(new Node(in));
            }
        }
    }

    private List<Graphable> toNodeGraphable(List<Node> oldList) {
        var out = new LinkedList<Graphable>();
        oldList.forEach(e -> out.add(e));
        return out;
    }

    private List<Graphable> variableToGraphable(List<Constatnt> oldList) {
        var out = new LinkedList<Graphable>();
        oldList.forEach(e -> out.add(e));
        return out;
    }

    @Override
    public List<Double> calculate(List<Double> in) {
        resetValues();
        for (int i = 0; i < input.size(); i++) {
            input.get(i).setValue(in.get(i));
        }
        return 
            nodes.get(nodes.size() - 1)
            .stream()
            .map(n -> n.value())
            .collect(Collectors.toList());
    }

    public void resetValues(){
        for (var list : nodes) {
            for (Node node : list) {
                node.reset();
            }
            
        }
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
    }

    @Override
    public double train(List<Double> input, List<Double> expected) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void nextGeneration(double stepSize) {
        // TODO Auto-generated method stub
        
    }

    public void printValues(){
        for (var list : nodes) {
            System.out.println();
            list.forEach(n -> System.out.print(n.value() + ", "));
                
        }
    }
}
