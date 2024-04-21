package java_training;

public class Multiplication extends Operation implements IOperation{

    public Multiplication(float a, float b) {
        super(a, b);
    }

    @Override
    public float operate() {
        return this.a*this.b;
    }
    
}
