package com.backery.backend.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.backery.backend.domain.MenuItem;
import com.my.backery.backend.domain.OrderItem;
import org.hibernate.service.spi.InjectService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FromJson {

    private ObjectMapper mapper;

    @Before
    public void init() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.findAndRegisterModules();
    }
    @Test
    public void menuItemFromJson() throws Exception {
        String menuItemJ = new String("{\"itemName\":\"aaa\"}");
        MenuItem mi = mapper.readValue(menuItemJ, MenuItem.class);
        assertThat(mi.getItemName(), is("aaa"));
    }

    @Test
    public void orderItemFromJson() throws Exception {
        String orderItemJ = new String("{\"menuItem\": 1}");
        OrderItem oi = mapper.readValue(orderItemJ, OrderItem.class);
        assertThat(oi.getQuantity(), is(1));
    }
}
