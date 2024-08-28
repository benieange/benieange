package example.adapters.controller;


import example.adapters.in.GererLivreAdapter;
import example.adapters.repository.LivreRepository;
import example.model.Livre;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/livre")
public class LivreController {
    private final GererLivreAdapter gererLivreAdapter;

    @PostMapping("/creer")
    public ResponseEntity<Livre> saveLivre(@RequestBody Livre livre) throws Exception {
        return ResponseEntity.ok(gererLivreAdapter.createLivre(livre));
    }
    @PutMapping("/modifier")
    public ResponseEntity<Livre> updateLivre(@RequestBody Livre livre) throws Exception {
        return ResponseEntity.ok(gererLivreAdapter.updateLivre(livre));
    }
    @DeleteMapping("/supprimer/{idlivre}")
    public void deleteLivre(@PathVariable Integer idlivre)  {
        gererLivreAdapter.deleteLivres(idlivre);
    }
    @GetMapping("/rechercherParId/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Integer idlivre)  {
        return ResponseEntity.ok(gererLivreAdapter.getLivreById(idlivre));
    }
    @GetMapping("/rechercherToutLivres")
    public ResponseEntity<List<Livre>> getAllivre(){
        return ResponseEntity.ok(gererLivreAdapter.getLivres());
    }
    @GetMapping("/rechercherParIsbn/{isbn}")
    public ResponseEntity<Livre> getAllivreIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(gererLivreAdapter.rechercherByIsbn(isbn)); }

    @GetMapping("/rechercherParAuteur/")
    public ResponseEntity<List<Livre>> getAllivreAuteur(@PathVariable String auteur){
        return ResponseEntity.ok(gererLivreAdapter.rechercherByAuteur(auteur));
    }
}
