package com.workshop.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/Api/V1")
public class GreatingController {

    @GetMapping("/")
    public ResponseEntity<String> getWelcom(){
        return ResponseEntity.ok("Welcom...!");
    }

    @GetMapping("/user")
    public ResponseEntity<String> user(){
        return ResponseEntity.ok("Welcom user...!");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Welcom admin...!");
    }

}