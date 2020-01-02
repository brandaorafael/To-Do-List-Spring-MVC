package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoData;
import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.service.ToDoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService){
        this.toDoItemService = toDoItemService;
    }

    @ModelAttribute
    public ToDoData toDoData(){
        return toDoItemService.getData();
    }

    // http://localhost:8080/To-Do-List-Spring-MVC/items
    @GetMapping(Mappings.ITEMS)
    public String item(){
        return ViewNames.ITEMS_LIST;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){
        return "redirect:/" + Mappings.ITEMS;
    }
}
