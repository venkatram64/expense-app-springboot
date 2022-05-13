package com.venkat.expense.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * This MBean will be used for setting the decimal places for adding
 * two double values.  For this open a  JConsole or Visual VM for
 * setting the decimal places
 */

public class CalculatorMain {

    public static void main(String[] args) throws Exception{
        Calculator calculator = new Calculator();
        registerWithJmxAgent(calculator);
        start(calculator);
    }

    private static void registerWithJmxAgent(Calculator service) throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.venkat.expense.mbean:type=Calculator");
        mBeanServer.registerMBean(service, name);
    }

    private static void start(Calculator service){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("----------------------");
            String strInput1 = getUserInput(scanner, "Enter first number...");
            double d1 = toDouble(strInput1);

            String strInput2 = getUserInput(scanner, "Enter first number...");
            double d2 = toDouble(strInput2);

            double sum = service.add(d1, d2);

            System.out.printf("sum = %s (rounded to %s decimal places) %n", sum, service.getDecimalPlaces());
        }
    }

    public static String getUserInput(Scanner scanner, String msg){
        System.out.println((msg + "> "));
        String strMsg = scanner.nextLine();
        if("exit".equals(strMsg)){
            System.exit(0);
        }
        return strMsg;
    }

    private static double toDouble(String input){
        try{
            return Double.parseDouble(input);
        }catch (NumberFormatException e){
            System.out.println("Not a valid number, defaulting to 0");
            return 0;
        }
    }
}
