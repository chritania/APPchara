package com.conching.APPchara.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.conching.APPchara.Model.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
