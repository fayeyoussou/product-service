package sn.youdev.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import sn.youdev.productservice.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}