package academy.learnprogramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    // http://localhost:8080/To-Do-List-Spring-MVC/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    // http://localhost:8080/To-Do-List-Spring-MVC/welcome
    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}