package com.example.flat.com.restMobileController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class RestMobileController {


    @GetMapping("/test")
    public String test() {
        return "HelloWorld";
    }
    
 
}
