package ovh.warczek.sklepinternetowy.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ovh.warczek.sklepinternetowy.Cart;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.util.Optional;

@Component
public class CartService {
    @Getter
    private final Cart cart;
    private final ItemRepository repo;

    CartService(ItemRepository repo, Cart cart) {
        this.cart = cart;
        this.repo = repo;
    }

    public void addItemToCart(long id)
    {
        Optional<Item> oItem = repo.findById(id);
        oItem.ifPresent(cart::addItem);
    }

    public void removeItemFromCart(long id)
    {
        Optional<Item> oItem = repo.findById(id);
        oItem.ifPresent(cart::removeItem);
    }

    public void removeAllItemsFromCart(long id)
    {
        Optional<Item> oItem = repo.findById(id);
        oItem.ifPresent(cart::removeAllOfItem);
    }
}
