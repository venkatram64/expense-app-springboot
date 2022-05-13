package com.venkat.expense.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class TodoListMain {
    public static void register() throws Exception{
        TodoListMBean mBean = new TodoList();
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.venkat.expense.mbean:type=TodoList");
        mBeanServer.registerMBean(mBean, name);
    }

    public static void main(String[] args) throws Exception{
        register();
        Thread.sleep(Long.MAX_VALUE);
    }
}
