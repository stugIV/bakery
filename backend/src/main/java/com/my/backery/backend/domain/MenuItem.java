package com.my.backery.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price", nullable = false)
    private Double price;

    public MenuItem(MenuItem m) {
        id = m.getId();
        itemName = m.getItemName();
        price = m.getPrice();
    }
}
