package ovh.warczek.sklepinternetowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import ovh.warczek.sklepinternetowy.model.Item;
import ovh.warczek.sklepinternetowy.repository.ItemRepository;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository repo;

    @Autowired
    public DbInit(ItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        repo.saveAll(List.of(
                new Item( "Laptop", new BigDecimal("300.00"), "https://images.pexels.com/photos/13736497/pexels-photo-13736497.jpeg"),
        new Item( "Komputer", new BigDecimal("1000.00"), "https://images.pexels.com/photos/5082562/pexels-photo-5082562.jpeg"),
        new Item( "Tablet", new BigDecimal("100.00"), "https://media.istockphoto.com/id/1486741827/pl/zdj%C4%99cie/r%C4%99cznie-trzymaj%C4%85c-cyfrowy-tablet-makiety-pustego-ekranu-zabierz-sw%C3%B3j-ekran-aby-umie%C5%9Bci%C4%87-na.webp?s=1024x1024&w=is&k=20&c=s-KYU7AmAIsdb7OZhBr-hFJTlOiXkfpIiy23YRqkwn0=")

        ));
    }
}
