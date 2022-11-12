package integerparser.network;

import java.util.List;

public interface Network {
    /**
     * Calculates an output give a input
     * @param in inputs
     * @return endnodes in network
     */

    public List<Double> value(List<Double> in);


    /**
     * Saves the network in a textfile
     */
    public void save();

    public static Network loadAsGraph(){
        return GraphNetwork.load();//Kanske ska göra met ett factory
    }

    public static Network loadAsMatrix(){
        //TODO
        throw new UnsupportedOperationException();
    }


}
