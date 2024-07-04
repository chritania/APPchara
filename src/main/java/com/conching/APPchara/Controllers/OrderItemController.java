package com.conching.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.conching.APPchara.Model.OrderItem;
import com.conching.APPchara.NotFoundException.OrderItemNotFoundException;
import com.conching.APPchara.Repository.OrderItemRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderItemController {

    final OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo){
        this.repo = repo;
    }

    //httpp://127.0.0.1:8080/orderItem
    //Get all order
    @GetMapping("/orderItem")
    public List<OrderItem> getOrderItems(){
        return repo.findAll();
    }
    
    //Get on order
    //http://127.0.0.1:8080/orderItem/2
    @GetMapping("/orderItem/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new OrderItemNotFoundException(id));
    }

    //http:127.0.0.1:8080/orderItem/new
    @PostMapping("/orderItem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new order item is added. Yey!";
    }

    //Delete endpoint
    //http:///127.0.0.1:8080/orderItem/delete/1
    @DeleteMapping("/orderItem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        repo.deleteById(id);
        return "An order item is deleted!";
    }
}