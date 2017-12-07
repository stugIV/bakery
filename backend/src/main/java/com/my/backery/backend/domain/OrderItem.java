package com.my.backery.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name  = "order_item")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderItem implements Serializable {

    private static final long SerialVersionUID = -6759934985430646146L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderItem() {

    }
//    @Column(name = "menu_item")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item")
    private MenuItem menuItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
