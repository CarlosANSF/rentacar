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
import inacap.webcomponent.rentacar.model.Transmision;
import org.springframework.http.HttpStatus;

import inacap.webcomponent.rentacar.repository.TransmisionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    @GetMapping()
    public Iterable<Transmision> list() {
        return transmisionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public  ResponseEntity<Transmision> get(@PathVariable String id) {
        
        Optional<Transmision> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Transmision transmisionEncontrado = aOptional.get();
            
            return new ResponseEntity<>(transmisionEncontrado, HttpStatus.FOUND);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Transmision> put(@PathVariable String id, @RequestBody Transmision transmisionEditar) {
        
        Optional<Transmision> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Transmision transmisionEncontrado = aOptional.get();
            
            transmisionEditar.setIdTransmision(transmisionEncontrado.getIdTransmision());
            
            transmisionRepository.save(transmisionEditar);
            
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transmision nuevoTransmision) {
        
        nuevoTransmision = transmisionRepository.save(nuevoTransmision);
        
        Optional<Transmision> aOptional = transmisionRepository.findById(nuevoTransmision.getIdTransmision());
        
        if (aOptional.isPresent()) {
            Transmision transmisionEncontrado = aOptional.get();
            
            return new ResponseEntity<>(transmisionEncontrado, HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
            
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Transmision> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            Transmision transmisionEncontrado = aOptional.get();
            
            transmisionRepository.deleteById(transmisionEncontrado.getIdTransmision());
            
            return new ResponseEntity<>(transmisionEncontrado, HttpStatus.OK);
            
        }else{
            
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            
        }   
    }
}
