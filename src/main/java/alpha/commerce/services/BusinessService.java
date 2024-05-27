package alpha.commerce.services;

import alpha.commerce.dto.BusinessDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BusinessService {
    public BusinessDto Save(BusinessDto dto);
    public BusinessDto findById(Long id);
    public BusinessDto findByCodeBusiness(String code);
    public List<BusinessDto> findAll();
    public void delete(Long id);

}
