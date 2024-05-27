package alpha.commerce.web.api;

import alpha.commerce.dto.BrandDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static alpha.commerce.utils.Constants.APP_ROOT;
public interface BrandApi {
    @PostMapping(value = APP_ROOT + "/brands/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BrandDto save(@RequestBody BrandDto dto);
    @GetMapping(value =APP_ROOT + "/brands/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BrandDto findById(@PathVariable("id") Long id);
    @GetMapping(value =APP_ROOT + "/brands/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BrandDto> findAll();
    @DeleteMapping(value =APP_ROOT + "/brands/delete/{idBrand}")
    public void delete(@PathVariable("idBrand") Long id);

}
