package alpha.commerce.repository;

import alpha.commerce.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    public Optional<Fournisseur> findFournisseurByCode(String code);
//    public List<Fournisseur> findFournisseurByBusinessCode(String businessCode);


}

