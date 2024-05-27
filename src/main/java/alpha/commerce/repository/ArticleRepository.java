package alpha.commerce.repository;

import alpha.commerce.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // requete JPQL

    // requete Native
    @Query(value = "select * from article where code = :code and nameProduct = :nameProduct", nativeQuery = true)
    public List<Article> findByCustomerNativeQuery(@Param("code") String c, @Param("nameProduct") String name);

    public List<Article> findByCodeIgnoreCaseAndNameProductIgnoreCase(String code, String nameProduct);

    public Optional<Article> findArticleByCode(String code);
}
