package com.conching.APPchara.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    //http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
