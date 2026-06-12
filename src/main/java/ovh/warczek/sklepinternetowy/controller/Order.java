package ovh.warczek.sklepinternetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.warczek.sklepinternetowy.Cart;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;
import ovh.warczek.sklepinternetowy.service.CartService;
import ovh.warczek.sklepinternetowy.service.ItemOperation;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class Order {

    private final CartService cartService;

    public Order(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart() {
        return "cartView";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") long id)
    {
        cartService.itemOperation(ItemOperation.INCREASE, id);
        return "cartView";
    }

    @GetMapping("/remove/{itemId}")
    public String removeItemFromCart(@PathVariable("itemId") long id)
    {
        cartService.itemOperation(ItemOperation.DECREASE, id);
        return "cartView";
    }

    @GetMapping("/removeAll/{itemId}")
    public String removeAllItemsFromCart(@PathVariable("itemId") long id)
    {
        cartService.itemOperation(ItemOperation.REMOVE, id);
        return "cartView";
    }
}
