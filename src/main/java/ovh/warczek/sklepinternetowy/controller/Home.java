package ovh.warczek.sklepinternetowy.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ovh.warczek.sklepinternetowy.Cart;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class Home {
    private final Cart cart;

    private final ItemRepository repo;

    @Autowired
    public Home(Cart cart, ItemRepository repo) {
        this.cart = cart;
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

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") long id, Model model)
    {
        Optional<Item> oItem = repo.findById(id);
        if(oItem.isPresent())
        {
            cart.addItem(oItem.get());
        }
        return "redirect:/";
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
