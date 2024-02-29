package java_training;

public class Addition extends Operation implements IOperation{

    public Addition(float a, float b) {
        super(a, b);
    }

    @Override
    public float operate() {
        return this.a+this.b;
    }
}