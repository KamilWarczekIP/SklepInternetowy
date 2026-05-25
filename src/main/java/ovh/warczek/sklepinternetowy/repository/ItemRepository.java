package ovh.warczek.sklepinternetowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ovh.warczek.sklepinternetowy.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
