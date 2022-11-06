package integerparser;

import java.util.List;

import integerparser.network.GraphNetwork;


public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        var list = List.of(3, 10 , 2, 5);
        var n = new GraphNetwork(list);
        System.out.println(n.calculate(List.of(1.0,1.0,1.0))); 
        n.printValues();
    }
}
