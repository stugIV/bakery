package com.my.backery.backend.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.domain.Order;
import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.service.OrderItemRepository;
import com.my.backery.backend.service.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody Order order) {
        Order o = orderRepository.save(order);
        for(OrderItem item:order.getItems()) {
            item.setOrder(o);
            orderItemRepository.save(item);
        }
        return new ResponseEntity(order.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(View.OrderView.class)
    public ResponseEntity getOrders(@RequestParam(name="id") Optional<Integer> orderId) {
        Collection<Order> orders = Collections.emptyList();
        if (!orderId.isPresent())
            orders = orderRepository.findAll();
        else {
            Order order = orderRepository.findOne(orderId.get());
            if (order != null)
                orders = Collections.singletonList(orderRepository.findOne(orderId.get()));
        }
        return new ResponseEntity(orders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Order> modifyOrder(@RequestParam(name="id") Integer orderId,
                                             @RequestBody List<OrderItem> items) {
        Order order = orderRepository.findOne(orderId);
        if (order == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
