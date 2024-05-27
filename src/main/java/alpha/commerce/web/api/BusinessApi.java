package alpha.commerce.web.api;

import alpha.commerce.dto.BusinessDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static alpha.commerce.utils.Constants.APP_ROOT;

public interface BusinessApi {
    @PostMapping(value = APP_ROOT + "/business/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDto Save(@RequestBody BusinessDto dto);
    @GetMapping(value = APP_ROOT + "/business/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDto findById(@PathVariable Long id);
    @GetMapping(value = APP_ROOT + "/business/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BusinessDto findByCodeBusiness(@PathVariable("code") String code);
    @GetMapping(value = APP_ROOT + "/business/allBusiness", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BusinessDto> findAll();
    @DeleteMapping(APP_ROOT + "/business/delete")
    public void delete(Long id);
}
