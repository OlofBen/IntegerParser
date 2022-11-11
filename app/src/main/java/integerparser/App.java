package integerparser;

import java.util.List;

import integerparser.network.GraphNetwork;


public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        var list = List.of(3, 10 , 10, 10, 5);
        var n = new GraphNetwork(list);
        var in = List.of(1.0, 0.4, 0.1);
        var exp = List.of(1.0, 0.0, 0.5, 0.3, 1.0);
        var first = n.calculate(in);
        System.out.println(first);
        var t1 = System.currentTimeMillis();
        var stepSize = 1000.0;
        while (System.currentTimeMillis() - t1 < 1000){
            var diff = n.train(in, exp);
            
            n.train(in, exp);
            n.train(in, exp);
            n.train(in, exp);
            n.train(in, exp);
            n.train(in, exp);
            n.train(in, exp);
            n.train(in, exp);
            System.out.println(diff);
            n.nextGeneration(stepSize);
            stepSize = stepSize * 0.8;
        }
    }
}
