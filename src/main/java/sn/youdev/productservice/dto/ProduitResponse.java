package sn.youdev.productservice.dto;

import java.io.Serializable;

/**
 * DTO for {@link sn.youdev.productservice.entity.Produit}
 */
public record ProduitResponse(Long id, String code, String libelle, double quantite, UniteResponse unite,
                              CategorieDto categorie) implements Serializable {
    /**
     * DTO for {@link sn.youdev.productservice.entity.Categorie}
     */
    public record CategorieDto(Long id, String nom) implements Serializable {
    }
}