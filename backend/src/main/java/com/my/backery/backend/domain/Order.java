package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.api.View;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.OrderView.class)
    private Integer id;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "order")
    @JsonView(View.OrderView.class)
    private List<OrderItem> items;
}
