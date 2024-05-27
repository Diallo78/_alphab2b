package alpha.commerce.repository;

import alpha.commerce.model.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemRepository extends JpaRepository<CommandeItem, Long> {
}
