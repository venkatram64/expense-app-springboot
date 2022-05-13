package com.venkat.expense.generics;

public class MyBox<T> {

    private T value;

    public MyBox(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void printType(){
        System.out.println(this.value.getClass());
    }
}
