package com.conching.APPchara.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ordertbl")
public class Order {

    private @Id
    @GeneratedValue Long id;
    private Long userId;
    private Double totalAmount;
    private String status;


    Order(){}
    
    public Order(Long userId, Double totalAmount, String status) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    //setters//

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void setUserName(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //getters//
    
    public Long getOrderId() {
        return id;
    }

    public Long get() {
        return userId;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }


    public String getStatus() {
        return status;
    }


}
