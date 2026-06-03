package ovh.warczek.sklepinternetowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class Order {
    @GetMapping("/cart")
    public String getCart() {
        return "cartView";
    }
}
