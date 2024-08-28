package example.adapters.repository;

import example.adapters.model.LivreEntity;
import example.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Integer> {
    List<LivreEntity> findLivreByAuteur (String auteur);

    LivreEntity findByIsbn(String isbn);
}
