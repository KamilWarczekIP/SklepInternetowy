package ovh.warczek.sklepinternetowy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

@Controller
@RequestMapping("/admin")
public class Admin {
    private final ItemRepository repo;

    @Autowired
    public Admin(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    private String adminPage() {
        return "adminview/addItem";
    }
    @PostMapping
    private String addItem(Item item) {
        repo.save(item);
        return "redirect:/";
    }
}
