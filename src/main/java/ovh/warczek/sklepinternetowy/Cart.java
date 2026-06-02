package ovh.warczek.sklepinternetowy;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ovh.warczek.sklepinternetowy.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartItem> items;
    public void addItem(Item item) {
        for (var i : items)
        {
            if(Objects.equals(i.getItem().getId(), item.getId()))
            {
                i.increaseCounter();
                return;
            }
        }
        items.add(new CartItem(item));
    }
    public void removeItem(Item item) {
        for (var i : items)
        {
            if(Objects.equals(i.getItem().getId(), item.getId()))
            {
                i.decreaseCounter();
                if(i.hasZeroItems())
                    items.remove(i);
                return;
            }
        }
    }
    public BigDecimal getSum() {
        BigDecimal suma = BigDecimal.valueOf(0.0);
        for (var i : items)
        {
            suma = suma.add(i.getPrice());
        }
        return suma;
    }
    public int getCount() {
        int suma = 0;
        for (var i : items)
        {
            suma += i.getCount();
        }
        return suma;
    }
    Cart() {
        items = new ArrayList<>();
    }
}
