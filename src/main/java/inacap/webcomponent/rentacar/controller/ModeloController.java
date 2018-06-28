/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Modelo;
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
import inacap.webcomponent.rentacar.repository.ModeloRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/modelo")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    @GetMapping()
    public Iterable<Modelo> list() {
        return modeloRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> get(@PathVariable String id) {
        Optional<Modelo> cOptional = modeloRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Modelo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> put(@PathVariable String id, @RequestBody Modelo modeloEditar) {
        Optional<Modelo> cOptional = modeloRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Modelo cEncontrado = cOptional.get();
        modeloEditar.setIdModelo(cEncontrado.getIdModelo());
        
        modeloRepository.save(modeloEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Modelo nuevoModelo) {
        
        nuevoModelo = modeloRepository.save(nuevoModelo);
        Optional<Modelo> cOptional = modeloRepository.findById(nuevoModelo.getIdModelo());
        if(cOptional.isPresent()){
        Modelo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Modelo> cOptional =modeloRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Modelo cEncontrado = cOptional.get();
                
                modeloRepository.deleteById(cEncontrado.getIdModelo());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
