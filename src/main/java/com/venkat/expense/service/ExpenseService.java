package com.venkat.expense.service;

import com.venkat.expense.model.Expense;
import com.venkat.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAll() {
        return expenseRepository.getAll();
    }

    public Expense update(Expense expense) {
        return expenseRepository.update(expense);
    }

    public long delete(String id) {
        return expenseRepository.delete(id);
    }

    public long delete(Expense expense) {
        return expenseRepository.delete(expense);
    }


}
