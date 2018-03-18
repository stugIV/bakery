package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.api.View;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonView({View.MenuView.class, View.OrderView.class})
    private Integer id;

    @Column(name = "item_name")
    @JsonView({View.MenuView.class, View.OrderView.class})
    private String itemName;

    @Column(name = "price", nullable = false)
    @JsonView(View.MenuView.class)
    private Double price;

    @Column(name="icon_path")
    @JsonView(View.MenuView.class)
    private String iconPath;

    public MenuItem(MenuItem m) {
        id = m.getId();
        itemName = m.getItemName();
        price = m.getPrice();
        iconPath = m.getIconPath();
    }

    @OneToMany(mappedBy = "menuItem")
//    @JsonView(View.MenuView.class)
    private List<OrderItem> orderItems;
}
