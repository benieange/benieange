package example.adapters.model;

import example.model.Livre;
import example.model.enumeration.Statut;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "livre")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class LivreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String auteur;

    @Column(unique = true)
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    /**convertir un objet du domain en un objet de persistence
     * @param livreEntity
     * @return Livre
     */

    public static Livre toDomainLivre(LivreEntity livreEntity){
        return new Livre.Builder()
                .id(livreEntity.id)
                .titre(livreEntity.titre)
                .auteur(livreEntity.auteur)
                .isbn(livreEntity.isbn)
                .statut(livreEntity.statut)
                .build();
    }

    /**
     * convertir un objet de persistence en un objet du domain
     * @param livre
     * @return
     */

    public static LivreEntity toEntity(Livre livre){
        return new LivreEntityBuilder()
                .id(livre.id())
                .titre(livre.titre())
                .auteur(livre.auteur())
                .isbn(livre.isbn())
                .statut(livre.statut())
                .build();
    }
}
