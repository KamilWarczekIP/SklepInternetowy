package ovh.warczek.sklepinternetowy;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> items;
    private Optional<CartItem> getCartItemByItem(Item item)
    {
        return items.stream().filter(i -> Objects.equals(i.getItem().getId(), item.getId())).findAny();
    }

    public void addItem(Item item) {
        getCartItemByItem(item).ifPresentOrElse(CartItem::increaseCounter, () -> {items.add(new CartItem(item));});
    }
    public void removeItem(Item item) {
        getCartItemByItem(item).ifPresentOrElse( i -> {
            i.decreaseCounter();
            if(i.hasZeroItems())
                items.remove(i);
        }, () -> {items.add(new CartItem(item));});
    }
    public BigDecimal getSum() {
        return items.stream().map(CartItem::getPrice).reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
    }
    public int getCount() {
        return items.stream().map(CartItem::getCount).reduce(0, Integer::sum);
    }
    Cart() {
        items = new ArrayList<>();
//        for (var i : repo.findAll())
//        {
//            addItem(i);
//        }
    }
}
