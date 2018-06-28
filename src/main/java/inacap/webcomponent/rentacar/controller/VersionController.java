/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Version;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.VersionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/version")
public class VersionController { 
    
    @Autowired
    private VersionRepository versionRepository;
    
    @GetMapping()
    public Iterable<Version> list() {
        return versionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Version> get(@PathVariable String id) {
        Optional<Version> cOptional = versionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Version cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Version> put(@PathVariable String id, @RequestBody Version versionEditar) {
        Optional<Version> cOptional = versionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Version cEncontrado = cOptional.get();
        versionEditar.setIdVersion(cEncontrado.getIdVersion());
        
        versionRepository.save(versionEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Version nuevoVersion) {
        
        nuevoVersion = versionRepository.save(nuevoVersion);
        Optional<Version> cOptional = versionRepository.findById(nuevoVersion.getIdVersion());
        if(cOptional.isPresent()){
        Version cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Version> cOptional = versionRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Version cEncontrado = cOptional.get();
                
                versionRepository.deleteById(cEncontrado.getIdVersion());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
