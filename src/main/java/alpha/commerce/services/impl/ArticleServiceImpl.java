package alpha.commerce.services.impl;

import alpha.commerce.dto.ArticleDto;
import alpha.commerce.exception.EntityNotFoundException;
import alpha.commerce.exception.ErrorCodes;
import alpha.commerce.exception.InvalidEntityException;
import alpha.commerce.model.Article;
import alpha.commerce.repository.ArticleRepository;
import alpha.commerce.services.ArticleService;
import alpha.commerce.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validateArticle(dto);
        if (!errors.isEmpty()){
           log.error("Article is not valid {} ", dto);
           throw new InvalidEntityException("L'article est invalid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        Article article = articleRepository.save(ArticleDto.toEntity(dto));
        return ArticleDto.formEntity(article);
    }
    @Override
    public ArticleDto findById(Long id) {
        if (id == null){
            log.error("Article ID is not null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);

        return article.map(ArticleDto::formEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + "n'est trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }
    @Override
    public ArticleDto findByCodeArticle(String code) {
        if (StringUtils.hasLength(code)) {
            log.error("Article `CODE` is null");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCode(code);

        return article.map(ArticleDto::formEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le `code` = " + code + " n'est trouvé dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND
                        )
                );
    }
    @Override
    public List<ArticleDto> findAll() {
        List<Article> articles = articleRepository.findAll();

        if (articles.isEmpty()) {
            throw new EntityNotFoundException("Aucun article n'est trouvé dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND);
        }

        return articles.stream()
                .map(ArticleDto::formEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Article `ID` is not null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
