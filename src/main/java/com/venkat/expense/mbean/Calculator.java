package com.venkat.expense.mbean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements CalculatorMBean {

    private int decimalPlaces = 2;

    /**
     * setting decimalPlaces is taken from the MBean (from JConsole or Visual VM)
     * if not provided by default is 2 places will be set
     * @param d1
     * @param d2
     * @return
     */
    public double add(double d1, double d2){
        BigDecimal bd1 = new BigDecimal(d1);
        BigDecimal bd2 = new BigDecimal(d2);
        BigDecimal sum = bd1.add(bd2);
        return sum.setScale(decimalPlaces, RoundingMode.HALF_UP).doubleValue();
    }


    @Override
    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public int getDecimalPlaces() {
        return decimalPlaces;
    }
}
