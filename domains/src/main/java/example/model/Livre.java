package example.model;

import example.model.enumeration.Statut;

public record Livre(Integer id, String titre, String auteur, String isbn, Statut statut) {

    public static final class Builder{
           private Integer id;
           private String titre;
           private String auteur;
           private String isbn;
           private Statut statut;

           public Builder() {

           }

           public static Builder builder(){
               return new Builder();
           }
           public Builder id(Integer val) {
               id = val;
               return this;
           }

           public Builder titre(String val) {
               titre = val;
               return this;
           }

           public Builder auteur(String val) {
               auteur = val;
               return this;
           }

           public Builder isbn(String val) {
               isbn = val;
               return this;
           }

           public Builder statut(Statut val) {
               statut = val;
               return this;
           }
           public Livre build() {
               return new Livre(id, titre, auteur, isbn, statut);
           }


       }

}

