package integerparser.network;

import java.util.List;

public interface ImprovableNetwork extends Network{
    /**
     * 
     * @param input the input of the network
     * @param expected the expected otput
     * @return sum of squared margin of error
     */
    public double train(List<Double> input, List<Double> expected);


    /**
     * Improves the network based on training
     * @param stepSize how big the change is.
     */
    public void nextGeneration(double stepSize);
}
