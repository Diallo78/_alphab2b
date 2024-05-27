package alpha.commerce.services;

import alpha.commerce.dto.BrandDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    public BrandDto save(BrandDto dto);
    public BrandDto findById(Long id);
    public List<BrandDto> findAll();
    public void delete(Long id);
}
