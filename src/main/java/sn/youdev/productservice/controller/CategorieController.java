package sn.youdev.productservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sn.youdev.productservice.dto.CategorieRequest;
import sn.youdev.productservice.dto.CategorieResponse;
import sn.youdev.productservice.exception.CategorieNotFoundException;
import sn.youdev.productservice.services.CategorieService;
import sn.youdev.productservice.services.CategorieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorie")
@PreAuthorize("hasRole('client_admin')")
@RequiredArgsConstructor
public class CategorieController {
    private final CategorieService service;
    private static final Logger logger = LogManager.getLogger(CategorieController.class);


    @GetMapping
    public ResponseEntity<List<CategorieResponse>> liste(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CategorieRequest request, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            return ResponseEntity.ok(service.save(request));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") final long id, @RequestBody @Valid final CategorieRequest request, Errors errors) throws CategorieNotFoundException {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            return ResponseEntity.ok(service.update(id,request));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategorieResponse> findOne(@PathVariable("id") final long id) throws CategorieNotFoundException {
        return ResponseEntity.ok(service.find(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final long id) throws CategorieNotFoundException {
        service.delete(id);
        return ResponseEntity.ok(true);
    }
}
