package alpha.commerce.repository;

import alpha.commerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByCode(String code);
    List<Client> findClientByBusinessCodeIsIgnoreCase(String businessCode);

}
