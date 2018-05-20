package com.my.backery.backend.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.domain.OrderItem;
import com.my.backery.backend.domain.View;
import com.my.backery.backend.service.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/order_item")
public class OrderItemRestController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(View.OrderItemView.class)
    public ResponseEntity getItems(@RequestParam(name="id") Optional<Integer> itemId) {
        Collection<OrderItem> orderItems = Collections.emptyList();
        if (!itemId.isPresent())
            orderItems = orderItemRepository.findAll();
        else {
            OrderItem orderItem = orderItemRepository.findOne(itemId.get());
            if (orderItem != null)
                orderItems = Collections.singletonList(orderItemRepository.findOne(itemId.get()));
        }
        return new ResponseEntity(orderItems, HttpStatus.OK);
    }}
