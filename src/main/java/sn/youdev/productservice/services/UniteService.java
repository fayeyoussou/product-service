package sn.youdev.productservice.services;

import sn.youdev.productservice.dto.UniteRequest;
import sn.youdev.productservice.dto.UniteResponse;
import sn.youdev.productservice.entity.Unite;
import sn.youdev.productservice.exception.UniteNotFoundException;

import java.util.List;

public interface UniteService {
    List<UniteResponse> getAll();
    UniteResponse save(UniteRequest request);

    UniteResponse update(Long id,UniteRequest request) throws UniteNotFoundException;

    void delete(Long id) throws UniteNotFoundException;

    UniteResponse find(Long id) throws UniteNotFoundException;

    Unite findOne(Long id) throws UniteNotFoundException;
}
