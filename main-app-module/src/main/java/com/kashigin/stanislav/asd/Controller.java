package com.kashigin.stanislav.asd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="test")
public class Controller {

    @GetMapping(produces = "application/json")
    public String asd() {
        return "Hello";
    }

}
