package alpha.commerce.services;

import alpha.commerce.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    public FournisseurDto save(FournisseurDto dto);
    public FournisseurDto findById(Long id);
    public FournisseurDto findByCodeFournisseur(String code);
    public List<FournisseurDto> findAll();
    public void disableFournisseur(Long id);
}
