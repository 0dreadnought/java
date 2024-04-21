package java_training;

public class Subtraction extends Operation implements IOperation{

    public Subtraction(float a, float b) {
        super(a, b);
    }

    @Override
    public float operate() {
        return this.a - this.b;
    }
    
}
