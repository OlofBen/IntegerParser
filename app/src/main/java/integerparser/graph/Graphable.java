package integerparser.graph;

/**
 * Graphable
 */
public interface Graphable {

    /**
     * Calculates the value, if not allready calculated and stores it in the component.
     * @return the value of a component in the graph
     */
    public double value();


    /**
     * Resets the stored value in the component
     */
    public void reset();

    /**
     * Calculates the dirivative of children
     * Note: needs to be in topological order 
     */
    public void dirive(); 
    
    /**
     * Sets the dirivative to {@dirivative}
     */
    public void setDirivative(double dirivative);
    
}