package sn.youdev.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.youdev.productservice.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}