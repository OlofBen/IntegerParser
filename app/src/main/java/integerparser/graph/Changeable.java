package integerparser.graph;

public interface Changeable {
    /**
     * Changes the component and/or the components children,
     * based om the dirivative
     * @param stepSize
     */
    public void changeBasedOnDirivative(double stepSize);
}
