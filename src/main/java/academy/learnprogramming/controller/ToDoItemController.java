package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoData;
import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.service.ToDoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
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
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ITEM)
    public String viewItem(@RequestParam(value = AttributeNames.TODO_ID) int id, Model model){
        ToDoItem toDoItem = toDoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.ITEM;
    }

    @GetMapping(value = {Mappings.ADD_ITEM, Mappings.EDIT_ITEM})
    public String addEditItem(@RequestParam(value = AttributeNames.TODO_ID, required = false, defaultValue = "-1") int id, Model model){
        ToDoItem toDoItem = toDoItemService.getItem(id);
        if(toDoItem == null){
            toDoItem = new ToDoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(value = {Mappings.ADD_ITEM, Mappings.EDIT_ITEM})
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){
        log.info("ToDoItem from form = {}", toDoItem);
        if(toDoItem.getId() == 0){
            toDoItemService.addItem(toDoItem);
        } else {
            toDoItemService.updateItem(toDoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam(AttributeNames.TODO_ID) int id){
        log.info("Deleting item with id = {}", id);
        toDoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
