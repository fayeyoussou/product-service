package sn.youdev.productservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sn.youdev.productservice.dto.CategorieResponse;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String nom;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Produit> produits = new ArrayList<>();
    public CategorieResponse toResponse(){
        return new CategorieResponse(this.id,this.nom,this.produits.stream().map(x-> new CategorieResponse.ProduitDto(x.getId(),x.getCode(),x.getLibelle())).toList());
    }
}
