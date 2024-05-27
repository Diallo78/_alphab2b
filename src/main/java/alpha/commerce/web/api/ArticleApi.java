package alpha.commerce.web.api;

import alpha.commerce.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static alpha.commerce.utils.Constants.APP_ROOT;

public interface ArticleApi {
    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(@RequestBody ArticleDto dto);
    @GetMapping(value = APP_ROOT + "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findById(@PathVariable Long id);
    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code);
    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> findAll();
    @DeleteMapping(value = APP_ROOT + "/articles/delete/{id}")
    public void delete(@PathVariable("id") Long id);
}
