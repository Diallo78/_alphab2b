package alpha.commerce.web;

import alpha.commerce.dto.BrandDto;
import alpha.commerce.services.BrandService;
import alpha.commerce.web.api.BrandApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class BrandController implements BrandApi {

    private BrandService brandService;

    @Override
    public BrandDto save(BrandDto dto) {
        return brandService.save(dto);
    }

    @Override
    public BrandDto findById(Long id) {
        return brandService.findById(id);
    }

    @Override
    public List<BrandDto> findAll() {
        return brandService.findAll();
    }

    @Override
    public void delete(Long id) {
        brandService.delete(id);
    }
}
