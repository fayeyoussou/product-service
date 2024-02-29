package sn.youdev.productservice.services;

import sn.youdev.productservice.dto.ProduitRequest;
import sn.youdev.productservice.dto.ProduitResponse;
import sn.youdev.productservice.entity.Produit;
import sn.youdev.productservice.entity.Unite;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.exception.ProduitNotFoundException;
import sn.youdev.productservice.exception.UniteNotFoundException;

import java.util.List;

public interface ProduitService {
    List<ProduitResponse> getAll();
    ProduitResponse save(ProduitRequest request) throws UniteNotFoundException, CategorieNotFoundException;

    ProduitResponse update(Long id,ProduitRequest request) throws ProduitNotFoundException, UniteNotFoundException, CategorieNotFoundException;

    void delete(Long id) throws ProduitNotFoundException;

    ProduitResponse find(Long id) throws ProduitNotFoundException;

    Produit findOne(Long id) throws ProduitNotFoundException;
}
