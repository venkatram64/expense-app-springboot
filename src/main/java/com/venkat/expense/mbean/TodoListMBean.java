package com.venkat.expense.mbean;

import java.util.List;

public interface TodoListMBean {

    String listAllTodos();
    void add(String todo);
    String delete(String todo);
    String getLatestTodo();
    List<String> getTodos();
}
