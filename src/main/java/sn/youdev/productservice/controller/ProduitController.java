package sn.youdev.productservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import sn.youdev.productservice.dto.ProduitRequest;
import sn.youdev.productservice.dto.ProduitResponse;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.exception.ProduitNotFoundException;
import sn.youdev.productservice.exception.UniteNotFoundException;
import sn.youdev.productservice.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produit")
@RequiredArgsConstructor
@PreAuthorize("hasRole('client_user')")
public class ProduitController {
    private final ProduitService service;
    private static final Logger logger = LogManager.getLogger(ProduitController.class);

    @GetMapping
    public ResponseEntity<List<ProduitResponse>> liste(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProduitRequest request, Errors errors) throws UniteNotFoundException, CategorieNotFoundException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            return ResponseEntity.ok(service.save(request));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") final long id, @RequestBody @Valid final ProduitRequest request, Errors errors) throws ProduitNotFoundException, UniteNotFoundException, CategorieNotFoundException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            return ResponseEntity.ok(service.update(id,request));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> findOne(@PathVariable("id") final long id) throws ProduitNotFoundException {
        return ResponseEntity.ok(service.find(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final long id) throws ProduitNotFoundException {
        service.delete(id);
        return ResponseEntity.ok(true);
    }
}
