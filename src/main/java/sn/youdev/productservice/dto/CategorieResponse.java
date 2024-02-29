package sn.youdev.productservice.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link sn.youdev.productservice.entity.Categorie}
 */
public record CategorieResponse(Long id, String nom, List<ProduitDto> produits) implements Serializable {
    /**
     * DTO for {@link sn.youdev.productservice.entity.Produit}
     */
    public record ProduitDto(Long id, String code, String libelle) implements Serializable {
    }
}