package com.my.backery.backend.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.domain.MenuItem;
import com.my.backery.backend.service.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuRESTController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody List<MenuItem> items) {
        for(MenuItem item : items) {
            MenuItem i = new MenuItem(item);
            menuRepository.save(i);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(View.MenuView.class)
    ResponseEntity get(){
        List<MenuItem> menu = menuRepository.findAll();
        return new ResponseEntity(menu, HttpStatus.OK);
    }
}
