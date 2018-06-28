/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Arriendo;
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
import inacap.webcomponent.rentacar.repository.ArriendoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    @Autowired
    private ArriendoRepository arriendoRepository; 
    
    @GetMapping()
    public Iterable<Arriendo> list() {
        return arriendoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Arriendo> get(@PathVariable String id) {
        Optional<Arriendo> cOptional = arriendoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Arriendo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Arriendo> put(@PathVariable String id, @RequestBody Arriendo arriendoEditar) {
        Optional<Arriendo> cOptional = arriendoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Arriendo cEncontrado = cOptional.get();
        arriendoEditar.setIdArriendo(cEncontrado.getIdArriendo());
        
        arriendoRepository.save(arriendoEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Arriendo nuevoArriendo) {
        
        nuevoArriendo = arriendoRepository.save(nuevoArriendo);
        Optional<Arriendo> cOptional = arriendoRepository.findById(nuevoArriendo.getIdArriendo());
        if(cOptional.isPresent()){
        Arriendo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Arriendo> cOptional = arriendoRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Arriendo cEncontrado = cOptional.get();
                
                arriendoRepository.deleteById(cEncontrado.getIdArriendo());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
