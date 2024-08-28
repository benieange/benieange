package example.ports.in;

import example.model.Livre;

import java.util.List;

public interface GererLivre {
    Livre ajouterLivre(Livre livre) throws Exception;

    Livre modifierLivre(Livre livre)  throws Exception;

    void supprimerLivre(Integer idlivre);

    Livre rechercherLivreParId(Integer id);

    List<Livre> rechercherToutLivres();

    Livre rechercherByIsbn(String isbn);

    List<Livre> rechercherByAuteur(String auteur);

    void disponibleLivre(Integer idlivre) throws Exception;
    void EmprunterLivre(Integer idlivre) throws Exception;
}
