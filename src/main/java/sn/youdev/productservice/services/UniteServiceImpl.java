package sn.youdev.productservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.youdev.productservice.dto.UniteRequest;
import sn.youdev.productservice.dto.UniteResponse;
import sn.youdev.productservice.entity.Unite;
import sn.youdev.productservice.exception.UniteNotFoundException;
import sn.youdev.productservice.repository.UniteRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UniteServiceImpl implements UniteService {
    private final UniteRepository repository;
    private static final Logger LOG = LogManager.getLogger(UniteServiceImpl.class);

    @Override
    public List<UniteResponse> getAll() {
        return repository.findAll().stream().map(Unite::toResponse).toList();
    }

    @Override
    public UniteResponse save(UniteRequest request) {
        LOG.log(Level.INFO,"saving request : "+request.toString());
        Unite unite = request.toEntity();
        repository.save(unite);
        return unite.toResponse();
    }

    @Transactional
    @Override
    public UniteResponse update(Long id, UniteRequest request) throws UniteNotFoundException {
        Unite unite = findOne(id);
        request.update(unite);
        repository.save(unite);
        return unite.toResponse();
    }

    @Override
    public void delete(Long id) throws UniteNotFoundException {
        Unite unite = findOne(id);
        repository.delete(unite);
    }

    @Override
    public UniteResponse find(Long id) throws UniteNotFoundException {
        return findOne(id).toResponse();
    }

    @Override
    public Unite findOne(Long id) throws UniteNotFoundException {
        return repository.findById(id).orElseThrow(UniteNotFoundException::new);
    }
}
