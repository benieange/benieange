package example.adapters.in;

import example.model.Livre;
import example.ports.in.GererLivre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GererLivreAdapter {
    private final GererLivre gererLivre;

    public Livre createLivre(Livre livre) throws Exception {
        return this.gererLivre.ajouterLivre(livre);
    }

    public Livre updateLivre(Livre livre) throws Exception {
        return this.gererLivre.modifierLivre(livre);
    }

    public void deleteLivres(Integer idlivre) {
        this.gererLivre.supprimerLivre(idlivre);
    }
    public Livre getLivreById(Integer livreId) {
       return this.gererLivre.rechercherLivreParId(livreId);
    }

    public List<Livre> getLivres() {
        return this.gererLivre.rechercherToutLivres();
    }

    public Livre rechercherByIsbn(String isbn){
        return this.gererLivre.rechercherByIsbn(isbn);
    }
    public List<Livre> rechercherByAuteur(String auteur) {
        return this.gererLivre.rechercherByAuteur(auteur);
    }


}
