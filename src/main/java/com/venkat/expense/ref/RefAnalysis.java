package com.venkat.expense.ref;

import com.venkat.expense.ref.model.MyBook;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class RefAnalysis {

    private static void process(){
        Class c = int.class;
        System.out.println(c.getName());
    }

    private static void process2(){
        System.out.println("********** Class Modification ******************");
        Class c = MyBook.class;
        System.out.println(c.getName());

        Constructor[] constructors = c.getConstructors();

        for(Constructor con : constructors){
            System.out.println("constructor name: " + con.getName());
            System.out.println("*********** Parameters ************");
            if(con.getParameterCount() == 0){
                System.out.println("no-arg constructor");
            }else{
                Parameter[] params = con.getParameters();
                for(Parameter p : params){
                    System.out.println(p.getName() + " : " + p.getType());
                }
            }
        }

        Method[] methods = c.getMethods();

        for(int i = 0; i < methods.length; i++){
            //System.out.println("Method # " + (i + 1) + " : " + methods[i].getName());
            System.out.println("Method # " + (i + 1) + " : " + Modifier.toString(methods[i].getModifiers()) + " "
                    + methods[i].getReturnType().getName() + "  " + methods[i].getName() + " - " +
                    Arrays.toString(methods[i].getParameters()));
        }
        System.out.println();
        Method[] declaredMethods = c.getDeclaredMethods();
        for(int i = 0; i < declaredMethods.length; i++){
            System.out.println("Method # " + (i + 1) + " : " + Modifier.toString(declaredMethods[i].getModifiers()) + " "
                    + declaredMethods[i].getReturnType().getName() + "  " + declaredMethods[i].getName() + " - " +
                    Arrays.toString(declaredMethods[i].getParameters()));
            if(declaredMethods[i].getName().startsWith("get")){
                System.out.println("Getter method...");
            }else if(declaredMethods[i].getName().startsWith("set")){
                System.out.println("Setter method...");
            }
        }

        System.out.println("Fields...");
        Field[] fields = c.getDeclaredFields();

        for(int i = 0; i < fields.length; i++){
            System.out.println("Field # " + (i + 1) + ": " + Modifier.toString(fields[i].getModifiers())
                    +" " + fields[i].getType().getName() + " " + fields[i].getName());
        }

        System.out.println("********** End Class Modification ******************");
    }

    //ctrl + p, ctrl + q
    private static void process3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //creating class object
        Class myBookClass = MyBook.class;
        //get required constructor
        Constructor bookConstructor = myBookClass.getConstructor(String.class, String.class, double.class);
        //creating object
        MyBook myBookObj = (MyBook) bookConstructor.newInstance("Java", "Joshva Block", 49.10);

        System.out.println(myBookObj);
        //get required method
        Method method = myBookClass.getMethod("process");
        //execute the method
        method.invoke(myBookObj);
        //getting private method
        Method method1 = myBookClass.getDeclaredMethod("m1");
        //above method is private method
        method1.setAccessible(true);
        method1.invoke(myBookObj);

        Field titleField = myBookClass.getDeclaredField("title");
        titleField.setAccessible(true);
        titleField.set(myBookObj, "The Complete Java");
        System.out.println(myBookObj);

        //
        System.out.println("******** Dynamic method execution *********");
        List<String> fields = Arrays.asList("Title", "Author", "Price");

        for(Method method2: myBookObj.getClass().getMethods()){
            if(method2.getParameterTypes().length > 0){
                continue;
            }
            String name = method2.getName().replaceFirst("get", "");
            //System.out.println("Field is " + name);
            if(fields.contains(name)){
                method2.setAccessible(true);
                System.out.println(method2.invoke(myBookObj));
            }
        }
    }

    public static void main(String[] args) {
        //process();
        process2();
        try {
            process3();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
