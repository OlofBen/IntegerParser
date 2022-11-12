package integerparser;

import java.util.List;

import integerparser.input.FromFile;
import integerparser.network.GraphNetwork;
import integerparser.network.NetworkTrainer;


public class App {
    public static void main(String[] args) {
        new App().run();
    }
    
    private void run() {
        var size = List.of(784, 20 , 15, 12, 10);
        var n = new GraphNetwork(size);
        var trainer = new NetworkTrainer(new FromFile("res/train.csv"));
        trainer.runFor(n, 200);
        
    }
}
