package alpha.commerce.services.impl;

import alpha.commerce.dto.BusinessDto;
import alpha.commerce.exception.EntityNotFoundException;
import alpha.commerce.exception.ErrorCodes;
import alpha.commerce.exception.InvalidEntityException;
import alpha.commerce.model.Business;
import alpha.commerce.repository.BusinessRepository;
import alpha.commerce.services.BusinessService;
import alpha.commerce.validator.BusinessValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private BusinessRepository repository;
    @Override
    public BusinessDto Save(BusinessDto dto) {
        List<String> errors = BusinessValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article is not valid {} ", dto);
            throw new InvalidEntityException("Business n'est pas valid", ErrorCodes.BUSINESS_NOT_VALID, errors);
        }

        return BusinessDto.fromEntity(repository.save(BusinessDto.toEntity(dto)));
    }

    @Override
    public BusinessDto findById(Long id) {
        if (id == null){
            log.error("Business `ID` is null");
            return null;
        }
        Optional<Business> business = repository.findById(id);

        BusinessDto businessDto = business.map(BusinessDto::fromEntity).orElseThrow(()->
            new EntityNotFoundException(
                "Aucun business avec le `code` = " + id + "n'est trouve dans la BDD",
                ErrorCodes.BUSINESS_NOT_FOUND
            )
        );

        return businessDto;
    }

    @Override
    public BusinessDto findByCodeBusiness(String code) {
        if (code == null){
            log.error("Business `CODE` is null");
            return null;
        }
        Optional<Business> business = repository.findBusinessByCode(code);
        return business.map(BusinessDto::fromEntity).orElseThrow(()->
                    new EntityNotFoundException("Aucun business avec le `code` = " + code + "n'est trouve dans la BDD",
                            ErrorCodes.BUSINESS_NOT_FOUND)
                );
    }

    @Override
    public List<BusinessDto> findAll() {
        List<Business> businessList = repository.findAll();
        if (businessList.isEmpty()){
            throw new EntityNotFoundException("Business is empty ", ErrorCodes.BUSINESS_NOT_FOUND);
        }

        return businessList.stream().map(BusinessDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Business `ID` is null");
            throw new EntityNotFoundException(" `ID` Business is empty ", ErrorCodes.BUSINESS_NOT_FOUND);
        }
        repository.deleteById(id);
    }
}
