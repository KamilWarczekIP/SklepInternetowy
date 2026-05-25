package ovh.warczek.sklepinternetowy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {


    private final ItemRepository repo;

    @Autowired
    public Home(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("items", repo.findAll());
        return "home.html";
    }

    // Dodałem od razu w ramach testów dostęp do plików pozostałych plików .html

    @GetMapping("/item")
    @ResponseBody
    public Item item()
    {
        return new Item("Laptop", new BigDecimal("100.00"), "https://picsum.photos/200");
    }

    @GetMapping("/cartView")
    public String cart()
    {
        return "cartView.html";
    }

    @GetMapping("/summary")
    public String summary()
    {
        return "summary.html";
    }
}
