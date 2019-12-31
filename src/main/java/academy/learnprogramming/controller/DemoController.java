package academy.learnprogramming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
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
    public String welcome(Model model){
        model.addAttribute("user", "Rafael");
        log.info("Model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() is called");
        return "Welcome to this Demo application!";
    }
}
