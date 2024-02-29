package sn.youdev.productservice.services;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.productservice.dto.CategorieRequest;
import sn.youdev.productservice.dto.CategorieResponse;
import sn.youdev.productservice.entity.Categorie;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.repository.CategorieRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository repository;
    private static final Logger logger = LogManager.getLogger(CategorieServiceImpl.class);

    @Override
    public List<CategorieResponse> getAll() {
        return repository.findAll().stream().map(Categorie::toResponse).toList();
    }

    @Override
    public CategorieResponse save(CategorieRequest request) {
        logger.info("adding new Categorie"+request.toString());
        Categorie categorie = request.toEntity();
        repository.save(categorie);
        return categorie.toResponse();    }

    @Transactional
    @Override
    public CategorieResponse update(Long id, CategorieRequest request) throws CategorieNotFoundException {
        Categorie categorie = findOne(id);
        request.update(categorie);
        repository.save(categorie);
        return categorie.toResponse();
    }

    @Override
    public void delete(Long id) throws CategorieNotFoundException {
        repository.delete(findOne(id));
    }

    @Override
    public CategorieResponse find(Long id) throws CategorieNotFoundException {
        return findOne(id).toResponse();
    }

    @Override
    public Categorie findOne(Long id) throws CategorieNotFoundException {
        return repository.findById(id).orElseThrow(CategorieNotFoundException::new);    }
}
