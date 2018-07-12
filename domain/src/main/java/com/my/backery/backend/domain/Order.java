package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {

    public enum Status { NEW, APPROVED, READY, ISSUED}

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.OrderView.class, View.OrderItemView.class})
    private Integer id;

    @OneToMany(mappedBy = "order")
    @JsonView(View.OrderView.class)
    private List<OrderItem> items;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView({View.OrderView.class, View.OrderItemView.class})
    private Date created;

    @Column(name="due")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView({View.OrderView.class,View.OrderItemView.class})
    private Date due;

    @Column(name="status")
    @JsonView({View.OrderView.class, View.OrderItemView.class})
    private Status status;

    @Column(name="cost")
    @JsonView(View.OrderView.class)
    private int cost;
}
