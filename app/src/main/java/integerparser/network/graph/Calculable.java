package integerparser.network.graph;

abstract public class Calculable implements Changeable{

    private double value;
    private boolean hasCalculated;
    protected double dirivative; 

    @Override
    public double value() {
        return hasCalculated ? value : calculateValue();
    }

    private double calculateValue(){
        value = calculate();
        return value;
    }

    protected abstract double calculate();

    @Override
    public void reset() {
        hasCalculated = false;
        value = 0;
        resetComponentes();        
    }

    protected abstract void resetComponentes(); 

    @Override
    public abstract void dirive();

    @Override
    public void setDirivative(double dirivative) {
        this.dirivative += dirivative;        
    }

    @Override
    public void changeOppositeGradient(double stepSize) {
        oppositeGradient(stepSize);  
        dirivative = 0;      
    }

    protected abstract void oppositeGradient(double stepSize);
    
}
