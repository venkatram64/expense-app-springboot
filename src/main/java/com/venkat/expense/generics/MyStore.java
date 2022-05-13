package com.venkat.expense.generics;

public class MyStore<T> {

    private T[] list;

    public MyStore(T[] list){
        this.list = list;
    }

    public void compare(MyStore<T> other){
        if(this.list.length > other.list.length){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    public void compare2(MyStore<?> other){
        if(this.list.length > other.list.length){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
