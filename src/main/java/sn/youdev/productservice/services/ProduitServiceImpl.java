package sn.youdev.productservice.services;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.productservice.dto.ProduitRequest;
import sn.youdev.productservice.dto.ProduitResponse;
import sn.youdev.productservice.entity.Produit;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.exception.ProduitNotFoundException;
import sn.youdev.productservice.exception.UniteNotFoundException;
import sn.youdev.productservice.repository.CategorieRepository;
import sn.youdev.productservice.repository.ProduitRepository;
import sn.youdev.productservice.repository.UniteRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private static final Logger logger = LogManager.getLogger(ProduitServiceImpl.class);

    private final ProduitRepository repository;
    private final CategorieRepository categorieRepository;
    private final UniteRepository uniteRepository;
    @Override
    public List<ProduitResponse> getAll() {
        return repository.findAll().stream().map(Produit::toResponse).toList();
    }

    @Override
    public ProduitResponse save(ProduitRequest request) throws UniteNotFoundException, CategorieNotFoundException {
        Produit produit = request.toEntity(categorieRepository,uniteRepository);
        repository.save(produit);
        return produit.toResponse();    }

    @Transactional
    @Override
    public ProduitResponse update(Long id, ProduitRequest request) throws ProduitNotFoundException, UniteNotFoundException, CategorieNotFoundException {
        Produit produit = findOne(id);
        request.update(produit,categorieRepository,uniteRepository);
        repository.save(produit);
        return produit.toResponse();
    }

    @Override
    public void delete(Long id) throws ProduitNotFoundException {
        repository.delete(findOne(id));
    }

    @Override
    public ProduitResponse find(Long id) throws ProduitNotFoundException {
        return findOne(id).toResponse();
    }

    @Override
    public Produit findOne(Long id) throws ProduitNotFoundException {
        return repository.findById(id).orElseThrow(ProduitNotFoundException::new);
    }
}
