package com.venkat.expense.controller;

import com.venkat.expense.model.Expense;
import com.venkat.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/")
    public Expense save(@RequestBody Expense expense){
        return expenseService.save(expense);
    }

    @GetMapping("/")
    public List<Expense> getAll(){
        return expenseService.getAll();
    }

    @PutMapping("/")
    public Expense update(@RequestBody Expense expense){
        return expenseService.update(expense);
    }

    @DeleteMapping(value = "/{id}")
    public long delete(@PathVariable String id){
        return expenseService.delete(id);
    }

}
