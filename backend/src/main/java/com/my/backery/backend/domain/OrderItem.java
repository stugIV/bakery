package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.api.View;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name  = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {

    private static final long SerialVersionUID = -6759934985430646146L;
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.OrderView.class, View.MenuView.class})
    private Integer id;

    @Column(name = "quantity")
    @JsonView({View.OrderView.class, View.MenuView.class})
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item")
    @JsonView(View.OrderView.class)
    private MenuItem menuItem;
}
