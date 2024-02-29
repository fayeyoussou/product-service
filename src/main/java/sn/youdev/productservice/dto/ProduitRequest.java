package sn.youdev.productservice.dto;

import jakarta.validation.constraints.*;
import lombok.Value;
import sn.youdev.productservice.entity.Produit;
import sn.youdev.productservice.entity.Unite;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.exception.UniteNotFoundException;
import sn.youdev.productservice.repository.CategorieRepository;
import sn.youdev.productservice.repository.UniteRepository;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link sn.youdev.productservice.entity.Produit}
 */
@Value
public class ProduitRequest implements Serializable {
    @NotNull(message = "ne peut etre null")
    @Size(message = "code entre 3 et 5 ", min = 3, max = 5)
    @NotEmpty(message = "ne peut etre vide")
    @NotBlank(message = "ne peut etre vide")
    String code;
    @NotNull
    @Size(min = 1)
    @NotEmpty
    @NotBlank
    String libelle;
    @PositiveOrZero(message = "ne peut etre negative")
    double quantite;
    Long idUnite;
    Long idCategorie;

    public Produit toEntity(CategorieRepository categorieRepository, UniteRepository uniteRepository) throws UniteNotFoundException, CategorieNotFoundException {
        Produit produit = new Produit();
        produit.setCode(code);
        produit.setLibelle(libelle);
        produit.setQuantite(quantite);
        produit.setUnite(uniteRepository.findById(idUnite).orElseThrow(UniteNotFoundException::new));
        produit.setCategorie(categorieRepository.findById(idCategorie).orElseThrow(CategorieNotFoundException::new));
        return produit;
    }
    public void update(Produit produit,CategorieRepository categorieRepository, UniteRepository uniteRepository) throws UniteNotFoundException, CategorieNotFoundException {
        produit.setCode(code);
        produit.setLibelle(libelle);
        produit.setQuantite(quantite);
        if(!Objects.equals(produit.getUnite().getId(), idUnite))produit.setUnite(uniteRepository.findById(idUnite).orElseThrow(UniteNotFoundException::new));
        if(!Objects.equals(produit.getCategorie().getId(), idCategorie))produit.setCategorie(categorieRepository.findById(idCategorie).orElseThrow(CategorieNotFoundException::new));
    }
}