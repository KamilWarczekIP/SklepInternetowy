package ovh.warczek.sklep_internetowy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Item {
    private String name;
    private BigDecimal price;
    private String imgURL;

}
