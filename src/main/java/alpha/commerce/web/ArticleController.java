package alpha.commerce.web;

import alpha.commerce.dto.ArticleDto;
import alpha.commerce.services.ArticleService;
import alpha.commerce.web.api.ArticleApi;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@AllArgsConstructor
public class ArticleController implements ArticleApi {

    ArticleService service;
    @Override
    public ArticleDto save(ArticleDto dto) {
        return service.save(dto);
    }

    @Override
    public ArticleDto findById(Long id) {
        return service.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        return service.findByCodeArticle(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
