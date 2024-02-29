package sn.youdev.productservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.youdev.productservice.dto.ProduitResponse;

@Entity
@Table(name = "produits")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)

    private String code;

    private String libelle;
    private double quantite;
    @ManyToOne
    @JoinColumn(name = "unite_id")
    private Unite unite;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
    public ProduitResponse toResponse(){
        return new ProduitResponse(id,code,libelle,quantite,unite.toResponse(),new ProduitResponse.CategorieDto(categorie.getId(), categorie.getNom()));
    }
}
