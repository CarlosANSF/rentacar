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
import inacap.webcomponent.rentacar.model.Traccion;
import org.springframework.http.HttpStatus;

import inacap.webcomponent.rentacar.repository.TraccionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/traccion")
public class TraccionController { 
    
    @Autowired
    private TraccionRepository traccionRepository;
    
    @GetMapping()
    public Iterable<Traccion> list() {
        return traccionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public  ResponseEntity<Traccion> get(@PathVariable String id) {
        
        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Traccion traccionEncontrado = aOptional.get();
            
            return new ResponseEntity<>(traccionEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Traccion> put(@PathVariable String id, @RequestBody Traccion traccionEditar) {
        
        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Traccion traccionEncontrado = aOptional.get();
            
            traccionEditar.setIdTraccion(traccionEncontrado.getIdTraccion());
            
            traccionRepository.save(traccionEditar);
            
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Traccion nuevoTraccion) {
        
        nuevoTraccion = traccionRepository.save(nuevoTraccion);
        
        Optional<Traccion> aOptional = traccionRepository.findById(nuevoTraccion.getIdTraccion());
        
        if (aOptional.isPresent()) {
            Traccion traccionEncontrado = aOptional.get();
            
            return new ResponseEntity<>(traccionEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Traccion> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Traccion traccionEncontrado = aOptional.get();
            
            traccionRepository.deleteById(traccionEncontrado.getIdTraccion());
            
            return new ResponseEntity<>(traccionEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }   
    }
}
