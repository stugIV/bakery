package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name  = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem implements Serializable {

    private static final long SerialVersionUID = -6759934985430646146L;
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.OrderView.class, View.MenuView.class})
    private Integer id;

    @Column(name = "amount")
    @JsonView({View.OrderView.class, View.MenuView.class, View.OrderItemView.class})
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonView(View.OrderItemView.class)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item")
    @JsonView({View.OrderView.class, View.OrderItemView.class})
    private MenuItem menuItem;

    private Date toStart;
}
