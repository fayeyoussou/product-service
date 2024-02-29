package sn.youdev.productservice.services;

import sn.youdev.productservice.dto.CategorieResponse;
import sn.youdev.productservice.dto.CategorieRequest;
import sn.youdev.productservice.entity.Categorie;
import sn.youdev.productservice.entity.Unite;
import sn.youdev.productservice.exception.CategorieNotFoundException;

import java.util.List;

public interface CategorieService {
    List<CategorieResponse> getAll();
    CategorieResponse save(CategorieRequest request);

    CategorieResponse update(Long id,CategorieRequest request) throws CategorieNotFoundException;

    void delete(Long id) throws CategorieNotFoundException;

    CategorieResponse find(Long id) throws CategorieNotFoundException;

    Categorie findOne(Long id) throws CategorieNotFoundException;
}
