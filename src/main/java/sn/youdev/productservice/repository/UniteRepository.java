package sn.youdev.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.youdev.productservice.entity.Unite;

public interface UniteRepository extends JpaRepository<Unite, Long> {
}