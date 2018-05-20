package com.backery.backend.test;

import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.service.OrderItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
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
