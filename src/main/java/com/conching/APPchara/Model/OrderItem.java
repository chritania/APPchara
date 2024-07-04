package com.conching.APPchara.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitemtbl")
public class OrderItem {

    private @Id
    @GeneratedValue Long orderitemId;
    private Long orderId;
    private Long productId;
    private int quantity;
    private Double price;


    OrderItem(){}
    
    public OrderItem(Long orderId, Long productId, int quantity, Double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    //setters//

    public void setOrderId(Long orderId){
        this.orderId = orderId;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    //getters//

    public Long getorderItemId() {
        return orderitemId;
    }
    
    public Long getorderId() {
        return orderId;
    }

    public Long getProductId() {
        return productId;
    }


    public int getQuantity() {
        return quantity;
    }


    public Double getPrice() {
        return price;
    }


}
