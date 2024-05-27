package alpha.commerce.repository;

import alpha.commerce.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    public Optional<Business> findBusinessByCode(String code);
}
