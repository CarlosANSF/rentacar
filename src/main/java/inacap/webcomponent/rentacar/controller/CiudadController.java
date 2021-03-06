/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Ciudad;
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
import inacap.webcomponent.rentacar.model.Carroceria;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.CiudadRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    
    @Autowired
    private CiudadRepository ciudadRepository;
    
    @GetMapping()
    public Iterable<Ciudad> list() {
        return ciudadRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> get(@PathVariable String id) {
        Optional<Ciudad> cOptional = ciudadRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Ciudad cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> put(@PathVariable String id, @RequestBody Ciudad ciudadEditar) {
        Optional<Ciudad> cOptional = ciudadRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Ciudad cEncontrado = cOptional.get();
        ciudadEditar.setIdCiudad(cEncontrado.getIdCiudad());
        
        ciudadRepository.save(ciudadEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Ciudad nuevoCiudad) {
        
        nuevoCiudad = ciudadRepository.save(nuevoCiudad);
        Optional<Ciudad> cOptional = ciudadRepository.findById(nuevoCiudad.getIdCiudad());
        if(cOptional.isPresent()){
        Ciudad cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Ciudad> cOptional = ciudadRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Ciudad cEncontrado = cOptional.get();
                
                ciudadRepository.deleteById(cEncontrado.getIdCiudad());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
