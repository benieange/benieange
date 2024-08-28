package example.ports.out;

import example.model.Livre;

import java.util.List;
import java.util.Optional;

public interface GestionLivre {
    Livre saveLivre(Livre livre) throws Exception;
    void deleteLivre(Livre livre);
    Livre getLivreById(Integer id);
    List<Livre> getLivre();
    Livre getLivreByIsbn(String isbn);
    List<Livre> getLivreByAuteur(String auteur);
}
