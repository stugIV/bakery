package com.my.backery.backend.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.my.backery.backend.domain.MenuItem;
import com.my.backery.backend.domain.View;
import com.my.backery.backend.service.MenuRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuRESTController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody List<MenuItem> items) {
        for(MenuItem item : items) {
            MenuItem i = new MenuItem(item);
            menuRepository.save(i);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(View.MenuView.class)
    public List<MenuItem> get(){
        List<MenuItem> menu = menuRepository.findAll();
        return menu;
    }

    @RequestMapping(value = "/icons/{iconName}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> icon(@PathVariable("iconName") String iconName) throws IOException {
        InputStream in = getClass().getResource("/images/"+iconName + ".png").openStream();
        byte[] media = IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<byte[]>(media, headers, HttpStatus.OK);
        return responseEntity;
    }
}
