package com.venkat.expense.mbean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList implements TodoListMBean{

    private static List<String> todos = new ArrayList<>();

    public TodoList(){
        todos.add("Testing the Application");
        todos.add("Attending Sprint Stand up call");
        todos.add("Demoing the End to End testing to the users");
        todos.add("Buying the Lunch");
        todos.add("Having the Lunch");
    }

    @Override
    public String listAllTodos() {
        return todos.stream().collect(Collectors.joining("\n"));
    }

    @Override
    public void add(String todo) {
        getTodos().add(todo);
    }

    @Override
    public String delete(String todo) {
        getTodos().remove(todo);
        return listAllTodos();
    }

    @Override
    public String getLatestTodo() {
        return todos.get(todos.size() - 1);
    }

    @Override
    public List<String> getTodos() {
        return todos;
    }
}
