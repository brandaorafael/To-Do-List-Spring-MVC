package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoData;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ToDoItemController {

    @ModelAttribute
    public ToDoData toDoData(){
        return new ToDoData();
    }

    // http://localhost:8080/To-Do-List-Spring-MVC/items
    @GetMapping(Mappings.ITEMS)
    public String item(){
        return ViewNames.ITEMS_LIST;
    }
}
