package com.venkat.expense.mbean;

import javax.swing.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class MemoryCheck {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Ready to go?");
        while(true){
            for(long i = 0; i < 100000; i++){
                list.add("" + i);
            }
            if(calculatePercentageMemoryUsed() > 85){
                System.out.println("Over 85 % utilization ");
                list.clear();
                JOptionPane.showMessageDialog(null, "List cleared...");
            }
        }
    }

    private static long calculatePercentageMemoryUsed(){
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
        long usedMemory = heapUsage.getUsed() / (1024 * 1024);
        long maxMemory = heapUsage.getMax() / (1024 * 1024);
        long percentageUsed = (long) (100.0 * ((1.0 * usedMemory)/(1.0 * maxMemory)));
        System.out.println(" Used v/s Max Memory: " + usedMemory + "M/" + maxMemory + "M "
                    + percentageUsed + "% List size: " + list.size());
        return percentageUsed;
    }
}
