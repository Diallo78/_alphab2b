package alpha.commerce.repository;

import alpha.commerce.model.SalesLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesLineRepository extends JpaRepository<SalesLine, Long> {
}
