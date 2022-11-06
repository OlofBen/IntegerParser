package integerparser;

import java.util.List;

import integerparser.network.GraphNetwork;


public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        var list = List.of(3, 10 , 2, 5);
        new GraphNetwork(list);
    }
}
