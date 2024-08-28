package example.service;

import example.DomainConfig.DomainService;
import example.model.Livre;
import example.model.enumeration.Statut;
import example.ports.in.GererLivre;
import example.ports.out.GestionLivre;

import java.util.List;


@DomainService
public class GererServiceLivre implements GererLivre {
    private final GestionLivre gestionLivre;

    public GererServiceLivre(GestionLivre gestionLivre) {
        this.gestionLivre = gestionLivre;
    }

    @Override
    public Livre ajouterLivre(Livre livre) throws Exception {

        //Verification des champs
        if(!verifierSyntaxe(livre))
        {
            throw new IllegalArgumentException("Remplissez les champs Correctement");
        }
        if(!isValidISBN(livre.isbn()))
        {
            throw new IllegalArgumentException("L'ISBN est invalide");
        }
        return this.gestionLivre.saveLivre(livre);
    }

    @Override
    public Livre modifierLivre(Livre livre) throws Exception {
        Livre toupdate=gestionLivre.getLivreById(livre.id());
        if(!verifierSyntaxe(livre)){
             throw new IllegalArgumentException("Remplissez les champs Correctement");
        }
        return this.gestionLivre.saveLivre(livre);
    }
    @Override
    public void supprimerLivre(Integer idlivre) {
        Livre deleterLivre = gestionLivre.getLivreById(idlivre);
        this.gestionLivre.deleteLivre(deleterLivre);
    }

    @Override
    public Livre  rechercherLivreParId(Integer id) {
        return gestionLivre.getLivreById(id);
    }

    @Override
    public List<Livre> rechercherToutLivres() {
        return gestionLivre.getLivre();
    }

    @Override
    public Livre rechercherByIsbn(String isbn) {
        return gestionLivre.getLivreByIsbn(isbn);
    }

    @Override
    public List<Livre> rechercherByAuteur(String auteur) {
        return gestionLivre.getLivreByAuteur(auteur);
    }

    @Override
    public void disponibleLivre(Integer idlivre) throws Exception {
        Livre livre = gestionLivre.getLivreById(idlivre);
        if (livre.statut() == Statut.DISPONIBLE) {
            throw new RuntimeException("Le livre est déjà disponible");
        }

        // Recréer un nouvel objet Livre avec le statut DISPONIBLE
        Livre livreMisAJour = new Livre.Builder()
                .titre(livre.titre())
                .auteur(livre.auteur())
                .isbn(livre.isbn())
                .statut(Statut.DISPONIBLE) // Changer le statut
                .build();

        gestionLivre.saveLivre(livreMisAJour);

    }

    @Override
    public void EmprunterLivre(Integer idlivre) throws Exception {

        Livre livre = gestionLivre.getLivreById(idlivre);
        if (livre.statut() == Statut.EMPRUNTE) {
            throw new RuntimeException("article emprunté");
        }
        Livre  livreEmprunter = new Livre.Builder()
                .titre(livre.titre())
                .auteur(livre.auteur())
                .isbn(livre.isbn())
                .statut(Statut.EMPRUNTE) //Changer le statut
                .build();

        gestionLivre.saveLivre(livreEmprunter);
    }

    //methode pour la verification des champs obligatoires
    private boolean verifierSyntaxe(Livre livre) {
        return !livre.titre().isEmpty()
                && livre.titre().length()>=2
                && !livre.auteur().isEmpty()
                && livre.auteur().length()>=2
                && !livre.isbn().isEmpty()
                && livre.isbn().length()>=2;
    }

    //methode pour la verification de la validité de l'isbn(longueur et format)
    private boolean isValidISBN(String isbn) {
        return isbn.matches("\\d{10}") || isbn.matches("\\d{14}");
    }



}
