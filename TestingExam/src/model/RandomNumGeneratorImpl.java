package model;

public class RandomNumGeneratorImpl implements RandomNumGenerator {
    @Override
    public int generate(int range) {
        return (int) (Math.random() * range + 1);
    }
}
