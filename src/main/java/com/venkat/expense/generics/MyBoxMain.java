package com.venkat.expense.generics;

public class MyBoxMain {

    public static void main(String[] args) {
        var myBox = new MyBox<Integer>(57);
        int val = myBox.getValue();
        System.out.println(val);
        myBox.printType();
    }
}
