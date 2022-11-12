package integerparser.network;

import integerparser.input.InputParser;

public class NetworkTrainer {
    private int numberOfTrainingTimes = 100;
    private int generation = 0;
    private InputParser inputParser;

    private double stepSize = 0.10;

    private double stepDecay = 1;
    
    public NetworkTrainer(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void runFor(ImprovableNetwork network, int generations){
        while (generation < generations) {
            run(network);
            generation++;
        }
    }

    private void run(ImprovableNetwork network) {
        var avrage = 0.0;
        for (int i = 0; i < numberOfTrainingTimes; i++) {
            avrage += runNext(network);
        }
        avrage = avrage/numberOfTrainingTimes;
        System.out.println(avrage);

        network.nextGeneration(stepSize/numberOfTrainingTimes);

        stepSize *= stepDecay;
        
    }

    private double runNext(ImprovableNetwork network) {
        var frame = inputParser.next();
        return network.train(frame.input, frame.expected);

    }
    
}
