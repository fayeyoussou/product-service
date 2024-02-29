package sn.youdev.productservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import sn.youdev.productservice.dto.UniteRequest;
import sn.youdev.productservice.dto.UniteResponse;
import sn.youdev.productservice.exception.UniteNotFoundException;
import sn.youdev.productservice.services.UniteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unite")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('client_admin','client_user')")
public class UniteController {
    private static final Logger logger = LogManager.getLogger(UniteController.class);

    private final UniteService service;
    @GetMapping
    public ResponseEntity<List<UniteResponse>> liste(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid UniteRequest request, Errors errors) {
        if(errors.hasErrors()){

            errors.getFieldErrors().forEach(fieldError -> logger.log(Level.ERROR,fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            logger.log(Level.INFO,String.format("Valid request save unite : %s",request.toString()));
            return ResponseEntity.ok(service.save(request));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") final long id, @RequestBody @Valid final UniteRequest request, Errors errors) throws UniteNotFoundException {
        if(errors.hasErrors()){
            logger.log(Level.ERROR,"Request Error");
            errors.getFieldErrors().forEach(fieldError -> logger.log(Level.ERROR,fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }else {
            return ResponseEntity.ok(service.update(id,request));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UniteResponse> findOne(@PathVariable("id") final long id) throws UniteNotFoundException {
        logger.log(Level.INFO,String.format("fetching unite of id : %d",id));
        return ResponseEntity.ok(service.find(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final long id) throws UniteNotFoundException {
        logger.log(Level.INFO,String.format("deleting unite of id : %d",id));

        service.delete(id);
        return ResponseEntity.ok(true);
    }


}
