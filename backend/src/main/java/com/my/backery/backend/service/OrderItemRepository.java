package com.my.backery.backend.service;

import com.my.backery.backend.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
