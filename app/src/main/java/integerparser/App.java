package integerparser;

import java.util.List;

import integerparser.input.Frame;
import integerparser.network.GraphNetwork;
import integerparser.network.NetworkTrainer;


public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        var list = List.of(3, 10 , 10, 10, 5);
        var n = new GraphNetwork(list);
        var in = List.of(1.0, 0.6, 0.2);
        var exp = List.of(0.5, 0.5, 0.5, 0.5, 0.5);
        var first = n.calculate(in);
        System.out.println(first);
        var trainer = new NetworkTrainer( () -> new Frame(in, exp));
        trainer.runFor(n, 200);
        var last = n.calculate(in);
        System.out.println(last);
        
    }
}
