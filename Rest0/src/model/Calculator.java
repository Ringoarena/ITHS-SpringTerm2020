package model;

import javax.ejb.Stateless;

@Stateless
public class Calculator {

    public Result addition(int i1, int i2) {
        Result result = new Result();
        result.setValue(i1+i2);
        return result;
    }
}
