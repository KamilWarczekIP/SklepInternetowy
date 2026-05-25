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
                new Item( "Laptop", new BigDecimal("300.00"), "https://picsum.photos/200"),
        new Item( "Komputer", new BigDecimal("1000.00"), "https://picsum.photos/200"),
        new Item( "Tablet", new BigDecimal("100.00"), "https://picsum.photos/200")

        ));
    }
}
