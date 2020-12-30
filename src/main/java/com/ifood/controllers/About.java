package com.ifood.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/about")
public class About {

    @GetMapping
    public ResponseEntity<?> execute() {
        return ResponseEntity.ok().build();
    }

}
