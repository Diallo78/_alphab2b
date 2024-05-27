package alpha.commerce.services;

import alpha.commerce.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    public ArticleDto save(ArticleDto dto);
    public ArticleDto findById(Long id);
    public ArticleDto findByCodeArticle(String code);
    public List<ArticleDto> findAll();
    public void delete(Long id);
}
