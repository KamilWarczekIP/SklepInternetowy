package ovh.warczek.sklepinternetowy;

import lombok.Getter;
import ovh.warczek.sklepinternetowy.model.Item;

import java.math.BigDecimal;

public class CartItem {
    @Getter
    private Item item;

    @Getter
    private int count;
    public BigDecimal getPrice()
    {
        return this.item.getPrice().multiply(new BigDecimal(this.count));
    }
    public void increaseCounter() {
        this.count++;
    }
    public void decreaseCounter() {
        this.count--;
    }
    public boolean hasZeroItems()
    {
        return this.count <= 0;
    }

    CartItem(Item item)
    {
        this.item = item;
        this.count = 1;
    }
}
