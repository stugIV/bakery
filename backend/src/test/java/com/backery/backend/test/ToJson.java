package com.backery.backend.test;

import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.service.OrderItemRepository;
import com.my.backery.backend.service.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration
//@SpringBootTest
@ComponentScan(basePackageClasses = OrderItemRepository.class)
@RunWith(SpringRunner.class)
public class ToJson {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    public void orderItemToJson() {
//        OrderItem o = orderItemRepository.findOne(1);
//        assertThat(o.getId(), is(1));
    }
}
