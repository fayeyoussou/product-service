package sn.youdev.productservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sn.youdev.productservice.entity.Categorie;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.productservice.entity.Categorie}
 */
public record CategorieRequest(
        @NotNull(message = "pas nulle") @Size(message = "la taille doit de minimum", min = 1) @NotEmpty String nom) implements Serializable {
    public Categorie toEntity(){
        Categorie categorie = new Categorie();
        categorie.setNom(this.nom);
        return categorie;
    }
    public void update(Categorie categorie){
        categorie.setNom(this.nom);
    }
}