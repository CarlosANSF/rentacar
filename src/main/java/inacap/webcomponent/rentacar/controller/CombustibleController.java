/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.rentacar.model.Combustible;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.CombustibleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/combustible")
public class CombustibleController {
    
    @Autowired
    private CombustibleRepository combustibleRepository;
    
    @GetMapping()
    public Iterable<Combustible> list() {
        return combustibleRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public  ResponseEntity<Combustible> get(@PathVariable String id) {
        
        Optional<Combustible> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Combustible combustibleEncontrado = aOptional.get();
            
            return new ResponseEntity<>(combustibleEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Combustible> put(@PathVariable String id, @RequestBody Combustible combustibleEditar) {
        
        Optional<Combustible> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Combustible combustibleEncontrado = aOptional.get();
            
            combustibleEditar.setIdCombustible(combustibleEncontrado.getIdCombustible());
            
            combustibleRepository.save(combustibleEditar);
            
            return new ResponseEntity<>(combustibleEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Combustible nuevoCombustible) {
        
        nuevoCombustible = combustibleRepository.save(nuevoCombustible);
        
        Optional<Combustible> aOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());
        
        if (aOptional.isPresent()) {
            Combustible combustibleEncontrado = aOptional.get();
            
            return new ResponseEntity<>(combustibleEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Combustible> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Combustible combustibleEncontrado = aOptional.get();
            
            combustibleRepository.deleteById(combustibleEncontrado.getIdCombustible());
            
            return new ResponseEntity<>(combustibleEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }   
    }
}
