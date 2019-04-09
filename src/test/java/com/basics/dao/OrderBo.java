package com.basics.dao;

import com.basics.exception.OrderNotFoundException;
import com.basics.exception.OrderSaveException;
import com.basics.exception.OrderUpdateExceprion;

public class OrderBo {

    public void save(Order order) throws OrderSaveException {
        if(order == null){
            throw new OrderSaveException("order id null");
        }
    }

    public void update(Order order) throws OrderUpdateExceprion, OrderNotFoundException {
        if(order == null){
            throw new OrderUpdateExceprion("Order is Empty");
        }

        throw new OrderNotFoundException("Order is not exists");
    }
}
