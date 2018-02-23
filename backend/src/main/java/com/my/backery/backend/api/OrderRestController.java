package com.my.backery.backend.api;

import com.my.backery.backend.domain.Order;
import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.service.OrderItemRepository;
import com.my.backery.backend.service.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody Order order) {
        for(OrderItem item:order.getItems())
            orderItemRepository.saveAndFlush(item);
        Order o = orderRepository.save(order);
        return new ResponseEntity(o.getId(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
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
