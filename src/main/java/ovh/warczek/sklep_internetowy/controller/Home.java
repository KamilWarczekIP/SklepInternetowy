package ovh.warczek.sklep_internetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ovh.warczek.sklep_internetowy.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    static List<Item> items = new ArrayList<Item>();
    static {
        items.add(new Item("Laptop", new BigDecimal("300.00"), "https://picsum.photos/200"));
        items.add(new Item("Komputer", new BigDecimal("1000.00"), "https://picsum.photos/200"));
        items.add(new Item("Tablet", new BigDecimal("100.00"), "https://picsum.photos/200"));
    }

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("items", items);;
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
