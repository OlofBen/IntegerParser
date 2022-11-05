package integerparser.graph;

public interface Changeable extends Graphable{
    /**
     * Changes the component and/or the components children,
     * based om the dirivative
     * @param stepSize
     */
    public void changeOppositeGradient(double stepSize);
}
