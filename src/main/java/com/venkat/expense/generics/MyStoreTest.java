package com.venkat.expense.generics;

public class MyStoreTest {

    public static void main(String[] args) {

        var names = new String[] {"John", "Jacky", "James", "Johnny"};
        var names2 = new String[] {"John", "Jacky", "James", "Johnny", "Joe"};
        var nums = new Integer[] {10, 20, 30};

        var myStore = new MyStore<>(names);
        var myStore2 = new MyStore<>(names2);
        var numArray = new MyStore<>(nums);
        myStore2.compare(myStore);

        numArray.compare2(myStore);
    }
}
