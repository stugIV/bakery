package com.my.backery.backend.service;

import com.my.backery.backend.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    @Query(value = "select menu_item, order_id, order_item_id, amount from orders o join order_item oi using(order_id) where created > :cdate order by due", nativeQuery = true)
    List<OrderItem> selectOrderItemsToBake(@Param("cdate")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ") Date createdDate);
}
