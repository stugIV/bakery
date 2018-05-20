package com.my.backery.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({View.MenuView.class, View.OrderView.class, View.OrderItemView.class})
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

    @Column(name = "time_to_bake", nullable = false)
    @JsonView({View.MenuView.class, View.OrderView.class, View.OrderItemView.class})
    private long timeToBake;

    public MenuItem(MenuItem m) {
        id = m.getId();
        itemName = m.getItemName();
        price = m.getPrice();
        iconPath = m.getIconPath();
        timeToBake = m.getTimeToBake();
    }

    @OneToMany(mappedBy = "menuItem")
//    @JsonView(View.MenuView.class)
    private List<OrderItem> orderItems;
}
