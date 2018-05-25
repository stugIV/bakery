package com.backery.backend.test;

import com.my.backery.backend.service.OrderItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration
//@SpringBootTest
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
