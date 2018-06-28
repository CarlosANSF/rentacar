/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Marca;
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
import inacap.webcomponent.rentacar.model.Marca;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.MarcaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping()
    public Iterable<Marca> list() {
        return marcaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Marca> get(@PathVariable String id) {
        Optional<Marca> cOptional = marcaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Marca cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Marca> put(@PathVariable String id, @RequestBody Marca marcaEditar) {
        Optional<Marca> cOptional = marcaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Marca cEncontrado = cOptional.get();
        marcaEditar.setIdMarca(cEncontrado.getIdMarca());
        
        marcaRepository.save(marcaEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Marca nuevoMarca) {
        
        nuevoMarca = marcaRepository.save(nuevoMarca);
        Optional<Marca> cOptional = marcaRepository.findById(nuevoMarca.getIdMarca());
        if(cOptional.isPresent()){
        Marca cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Marca> cOptional = marcaRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Marca cEncontrado = cOptional.get();
                
                marcaRepository.deleteById(cEncontrado.getIdMarca());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
