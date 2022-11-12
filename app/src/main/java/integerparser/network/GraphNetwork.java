package integerparser.network;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import integerparser.network.graph.*;

public class GraphNetwork implements ImprovableNetwork {

    private List<Constatnt> input;
    private List<List<Node>> nodes;
    private List<EndNode> endNodes; //Usted when improving the network  
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
        endRow(nodes.get(nodes.size() - 1));
    }

    private void endRow(List<Node> lastRow) {
        endNodes = new LinkedList<>();
        lastRow.forEach( x -> endNodes.add(new EndNode(x)));
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

    
    
    private void calculate(List<Double> in) {
        resetValues();
        for (int i = 0; i < input.size(); i++) {
            input.get(i).setValue(in.get(i));
        }
        for (var nodeList : nodes) {
            nodeList
            .stream()
            .parallel()
            .forEach(x -> x.value());
        }
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
        calculate(input);
        for (int i = 0; i < endNodes.size(); i++) {
            endNodes.get(i).setExpected(expected.get(i));
        }
        var sum = endNodes.stream().mapToDouble(endNode -> endNode.value()).sum();
        sendDirivatives();
        return sum;
    }

    private void sendDirivatives() {
        endNodes.forEach(x -> x.dirive());
        for (int i = nodes.size() - 1; i >= 0 ; i--) {
            nodes.get(i).forEach(n -> n.dirive());
        }
    }

    @Override
    public void nextGeneration(double stepSize) {
        nodes.forEach( 
            x -> 
            x.forEach(
                n -> 
                n.changeOppositeGradient(stepSize))
        );        
    }

    public void printValues(){
        for (var list : nodes) {
            System.out.println();
            list.forEach(n -> System.out.print(n.value() + ", "));
                
        }
    }

    @Override
    public List<Double> value(List<Double> in) {
        calculate(in);
        return nodes
            .get(nodes.size() - 1)
            .stream()
            .map(x -> x.value())
            .collect(Collectors.toList());
    }
}
