package com.my.backery.backend.domain;

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
    private Integer id;

    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "order")//(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private List<OrderItem> items;
}
