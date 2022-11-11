package integerparser.input;

import java.util.List;

public class Frame {

    public List<Double> input;
    public List<Double> expected;

    public Frame(List<Double> input, List<Double> expected) {
        this.input = input;
        this.expected = expected;
    }

    
}
