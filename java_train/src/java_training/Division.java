package java_training;

public class Division extends Operation implements IOperation{

    public Division(float a, float b) {
        super(a, b);
    }

    @Override
    public float operate() {
        return this.a/this.b;
    }
    
}