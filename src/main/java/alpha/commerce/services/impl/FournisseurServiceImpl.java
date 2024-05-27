package alpha.commerce.services.impl;

import alpha.commerce.dto.FournisseurDto;
import alpha.commerce.exception.EntityNotFoundException;
import alpha.commerce.exception.ErrorCodes;
import alpha.commerce.exception.InvalidEntityException;
import alpha.commerce.model.Fournisseur;
import alpha.commerce.repository.FournisseurRepository;
import alpha.commerce.services.FournisseurService;
import alpha.commerce.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository repository;

    public FournisseurServiceImpl(FournisseurRepository repository){
        this.repository = repository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validateFournisseur(dto);
        if (!errors.isEmpty()){
            log.error("Fournisseur is invalid {} ", dto);
            throw new InvalidEntityException("Fournisseur is not valid", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }
        Fournisseur fournisseur = repository.save(FournisseurDto.toEntity(dto));
        return FournisseurDto.FromEntity(fournisseur);
    }

    @Override
    public FournisseurDto findById(Long id) {
        if (id == null){
            log.error("Fournisseur `ID` is empty ");
            return null;
        }

        Fournisseur fournisseur = repository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Aucun Fournisseur avec `l'ID` = " + id + "n'est trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
            );

        FournisseurDto fournisseurDto = FournisseurDto.FromEntity(fournisseur);
        return fournisseurDto;
    }

    @Override
    public FournisseurDto findByCodeFournisseur(String code) {
        if (code == null || !code.isBlank()){
            log.error("Fournisseur `Code` is empty ");
            return null;
        }

        Optional<Fournisseur> fournisseur = repository.findFournisseurByCode(code);
        FournisseurDto fournisseurDto = FournisseurDto.FromEntity(fournisseur.get());
        return Optional.of(fournisseurDto).orElseThrow(()->
                new EntityNotFoundException("Aucun Fournisseur avec le `code` = " + code + "n'est trouve dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        List<FournisseurDto> dtos = repository.findAll().stream()
               .map(FournisseurDto::FromEntity).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public void disableFournisseur(Long id) {

    }
}
