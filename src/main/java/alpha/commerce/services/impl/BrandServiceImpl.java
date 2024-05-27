package alpha.commerce.services.impl;

import alpha.commerce.dto.BrandDto;
import alpha.commerce.exception.EntityNotFoundException;
import alpha.commerce.exception.ErrorCodes;
import alpha.commerce.exception.InvalidEntityException;
import alpha.commerce.model.Brand;
import alpha.commerce.repository.BrandRepository;
import alpha.commerce.services.BrandService;
import alpha.commerce.validator.BrandValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    BrandRepository brandRepository;
    @Override
    public BrandDto save(BrandDto dto) {
        List<String> errors = BrandValidator.validateBrand(dto);
       if (!errors.isEmpty()){
           log.error("Brand is not valid {} ", dto);
           throw new InvalidEntityException("Brand n'est pas valid", ErrorCodes.BRAND_NOT_INVALID, errors);
       }

       Brand brand = brandRepository.save(BrandDto.toEntity(dto));
       return BrandDto.fromEntity(brand);
    }

    @Override
    public BrandDto findById(Long id) {
        if (id == null){
            log.error("Brand ID is not null\"");
            return null;
        }

        Optional<Brand> brand = brandRepository.findById(id);

        return brand.map(BrandDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("Aucun `Brand` avec l'ID = " + id + " n'est trouvé dans la BDD",
                                ErrorCodes.BRAND_NOT_FOUND)
                );
//        Optional<Brand> brand = brandRepository.findById(id);
//
//        if (!brand.isPresent()) {
//            throw new EntityNotFoundException("Aucun `Brand` avec l'ID = " + id + " n'est trouvé dans la BDD",
//                    ErrorCodes.BRAND_NOT_FOUND);
//        }
//
//        BrandDto brandDto = BrandDto.fromEntity(brand.get());
//        return brandDto;
    }

    @Override
    public List<BrandDto> findAll() {
        List<Brand> brands = brandRepository.findAll();
        if (brands.isEmpty()) {
            throw new EntityNotFoundException("Data brand is empty", ErrorCodes.BRAND_NOT_FOUND);
        }

        return brands.stream()
                .map(BrandDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Brand `ID` is not null");
            return;
        }
        brandRepository.deleteById(id);
    }
}
