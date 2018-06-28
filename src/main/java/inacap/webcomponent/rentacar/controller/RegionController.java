/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Region;
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
import inacap.webcomponent.rentacar.model.Modelo;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.RegionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/region")
public class RegionController {
    
    @Autowired
    private RegionRepository regionRepository;
    
    @GetMapping()
    public Iterable<Region> list() {
        return regionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Region> get(@PathVariable String id) {
        Optional<Region> cOptional = regionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Region cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Region> put(@PathVariable String id, @RequestBody Region regionEditar) {
        Optional<Region> cOptional = regionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Region cEncontrado = cOptional.get();
        regionEditar.setIdRegion(cEncontrado.getIdRegion());
        
        regionRepository.save(regionEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Region nuevoRegion) {
        
        nuevoRegion = regionRepository.save(nuevoRegion);
        Optional<Region> cOptional = regionRepository.findById(nuevoRegion.getIdRegion());
        if(cOptional.isPresent()){
        Region cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Region> cOptional =regionRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Region cEncontrado = cOptional.get();
                
                regionRepository.deleteById(cEncontrado.getIdRegion());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
