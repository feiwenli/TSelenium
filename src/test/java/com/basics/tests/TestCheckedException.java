package com.basics.tests;

import com.basics.dao.Order;
import com.basics.dao.OrderBo;
import com.basics.exception.OrderNotFoundException;
import com.basics.exception.OrderSaveException;
import com.basics.exception.OrderUpdateExceprion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCheckedException {

    OrderBo orderBo;
    Order data;

    @BeforeTest
    void setUp(){

        orderBo = new OrderBo();
        data = new Order();
        data.setId(1000);
        data.setCreateBy("maxsu");
    }

    @Test(expectedExceptions = OrderSaveException.class)
    public void throwIfOrderIsNull() throws OrderSaveException{
        orderBo.save(null);
    }

    @Test(expectedExceptions = {OrderUpdateExceprion.class, OrderNotFoundException.class})
    public void throwIfOrderIsNotExists() throws OrderUpdateExceprion, OrderNotFoundException, OrderUpdateExceprion {
        orderBo.update(data);
    }


}
