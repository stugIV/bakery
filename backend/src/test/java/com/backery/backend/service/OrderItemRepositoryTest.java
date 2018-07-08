package com.backery.backend.service;

import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.service.OrderItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
//@ContextConfiguration
public class OrderItemRepositoryTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Configuration
    @EnableJpaRepositories
    static class TestConfiguration {}

//    @Test
    public void getByDate() {
        Date date = new Date();
        List<OrderItem> queueItems = orderItemRepository.selectOrderItemsToBake(date);
        assertThat(queueItems.size(), is(1));
    }
}
