package model;

public class RandomNumGeneratorMock implements RandomNumGenerator {
    int answer;

    @Override
    public int generate(int range) {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

}
