package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IntegerPair {
    int i1;
    int i2;

    public IntegerPair(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public IntegerPair() {
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }
}
