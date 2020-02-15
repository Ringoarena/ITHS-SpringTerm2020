package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result {
    private double value;

    public Result() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
