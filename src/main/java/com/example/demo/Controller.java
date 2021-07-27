package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;



@RestController
public class Controller {
    @Autowired
    Repo repository;
    
    @GetMapping("/")
    public String getRoot() {
        return "The root is able to communicate";
    }
    @GetMapping("/order")
    public List<DemoOrder> getOrders() {
        return repository.findAll();
    }

    @GetMapping("/order/{id}")
    public DemoOrder getOrderById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/order")
    public DemoOrder createOrder(@RequestBody DemoOrder order ) {
        return repository.save(order);
    }

    @PutMapping("/order/{id}")
    public DemoOrder updateOrder(@PathVariable Long id, @RequestBody DemoOrder updatedOrder) {
        DemoOrder currentOrder = repository.findById(id).orElse(null);
        if(currentOrder == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error: 404 order data not found");
        }

        currentOrder.setName(updatedOrder.getName());
        currentOrder.setDrink(updatedOrder.getDrink());
        currentOrder.setEntree(updatedOrder.getEntree());

        return repository.save(currentOrder);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}



