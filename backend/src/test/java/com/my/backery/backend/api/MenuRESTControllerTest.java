package com.my.backery.backend.api;

import com.my.backery.backend.domain.MenuItem;
import com.my.backery.backend.service.MenuRepository;
import com.my.backery.backend.service.OrderItemRepository;
import com.my.backery.backend.service.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MenuRESTController.class)
@AutoConfigureMockMvc(secure=false)
public class MenuRESTControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuRESTController controller;

    @MockBean
    private MenuRepository repository;

    @MockBean
    private OrderItemRepository oiRepo;

    @MockBean
    private OrderRepository oRepo;

    @Test
    public void getMenu() throws Exception {
        MenuItem mi = new MenuItem();
        mi.setItemName("Item Name");

        List<MenuItem> menuItems = Collections.singletonList(mi);
        given(controller.get()).willReturn(menuItems);

        mockMvc.perform(get("/menu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].itemName", is(mi.getItemName())))
                .andDo(print());
    }
}