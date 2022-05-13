package com.venkat.expense.ref;

import java.lang.reflect.Array;
import java.util.Random;

//dynamically creating the object array(int, double, string) and populating and displaying
//them
public class ArrayElements {

    static Object makeArray(int len, Class<?> c){
        //creating object array of "len"
        Object array = Array.newInstance(c, len);
        Random random = new Random();
        for (int i = 0; i < len; i++){
            if(c == int.class) {
                //populating the created object
                Array.set(array, i, random.nextInt(i + 10));
            }
            if(c == double.class) {
                //populating the created object
                Array.set(array, i, random.nextDouble(i + 10));
            }
            if(c == String.class) {
                //populating the created object
                Array.set(array, i, randomMsg());
            }
        }
        return array;
    }

    private static String randomMsg(){

        int leftLimit = 48; // 0
        int rightLimit = 122; // z

        int targetStringLength = 10;
        Random random = new Random();

        String msg = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder :: new, StringBuilder::appendCodePoint, StringBuilder :: append)
                .toString();

        return msg;
    }

    static void printArray(Object array){
        //gives the type of object
        Class<?> c = array.getClass().getComponentType();
        for(int i = 0; i < Array.getLength(array); i++){
            if(c == int.class){
                //get element from array object
                int ele = Array.getInt(array, i);
                System.out.format("%d ", ele);
            }
            if(c == double.class){
                //get element from array object
                double ele = Array.getDouble(array, i);
                System.out.format("%4.2f ", ele);
            }
            if(c == String.class){
                //get element from array object
                String ele = (String)Array.get(array, i);
                System.out.format("%s ", ele);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try{
            Object array = makeArray(10, int.class);
            printArray(array);
            Object array2 = makeArray(10, double.class);
            printArray(array2);
            Object array3 = makeArray(10, String.class);
            printArray(array3);
        }catch (Exception e){
            e.printStackTrace(System.err);
        }
    }
}
