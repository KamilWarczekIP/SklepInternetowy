package ovh.warczek.sklep_internetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.warczek.sklep_internetowy.model.Item;

@Controller
@RequestMapping("/admin")
public class Admin {
    @GetMapping
    private String adminPage() {
        return "adminview/addItem";
    }
    @PostMapping
    private String addItem(Item item) {
        Home.items.add(item);
        return "redirect:/";
    }
}
