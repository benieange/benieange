package example.adapters.out;

import example.adapters.model.LivreEntity;
import example.adapters.repository.LivreRepository;
import example.model.Livre;
import example.ports.out.GestionLivre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GestionLivreAdapter implements GestionLivre {
    private LivreRepository livreRepository ;

    @Override
    public Livre saveLivre(Livre livre) throws Exception {
        return LivreEntity
                .toDomainLivre(livreRepository
                        .save(LivreEntity.toEntity(livre)));
    }

    @Override
    public void deleteLivre(Livre livre) {
        livreRepository.delete(toEntity(livre));

    }

    @Override
    public Livre getLivreById(Integer id) {
        Optional<LivreEntity> livreOptional = this.livreRepository.findById(id);
        return toDomainLivre(livreOptional.get());
    }

    @Override
    public List<Livre> getLivre() {
        return livreRepository.findAll()
                .stream()
                .map(this::toDomainLivre)
                .toList();
    }


    @Override
    public Livre getLivreByIsbn(String isbn) {
        return toDomainLivre(livreRepository.findByIsbn(isbn));
    }

    @Override
    public List<Livre> getLivreByAuteur(String auteur) {
        return livreRepository.findLivreByAuteur(auteur)
                .stream()
                .map(this::toDomainLivre)
                .toList();
    }

    /**
     * @param livre
     * @return
     */

    private LivreEntity toEntity(Livre livre){return LivreEntity.toEntity(livre);}

    /**
     *
     * @param livreEntity
     * @return
     */
    private Livre toDomainLivre(LivreEntity livreEntity){return LivreEntity.toDomainLivre(livreEntity);}


}
