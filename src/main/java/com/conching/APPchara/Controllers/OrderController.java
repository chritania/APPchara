package com.conching.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.conching.APPchara.Model.Order;
import com.conching.APPchara.Model.Users;
import com.conching.APPchara.NotFoundException.OrderNotFoundException;
import com.conching.APPchara.Repository.OrderRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class OrderController {

    OrderRepository repo;

    public OrderController(OrderRepository repo){
        this.repo = repo;
    }

    //httpp://127.0.0.1/order
    //Get all order
    @GetMapping("/order")
    public List<Order>getusers(){
        return repo.findAll();
    }
    
    //Get on order
    //http://127.0.0.1:8080/order/2
    @GetMapping("/order/{id}")
    public Order geUsersById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    //http:127.0.0.1:8080/order/new
    @PostMapping("/order/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order is added. Yey!";
    }

    //Delete endpoint
    //http:///127.0.0.1:8080/order/delete/1
    @DeleteMapping("/order/delete/{id}")
    public String deleteUsers(@PathVariable Long id){
        repo.deleteById(id);
        return "A users is deleted!";
    }
}
