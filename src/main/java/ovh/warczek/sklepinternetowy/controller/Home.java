package ovh.warczek.sklepinternetowy.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.*;

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

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") long id, Model model, HttpSession session)
    {
        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>)session.getAttribute("cart");
        if(cart == null)
        {
            cart = new ArrayList<Item>();
        }
        Optional<Item> itemToAdd = repo.findById(id);
        if(itemToAdd.isPresent())
        {
            Item item = itemToAdd.get();
            cart.add(item);
            session.setAttribute("cart", cart);
        }

        model.addAttribute("items", repo.findAll());
        return "home.html";
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
