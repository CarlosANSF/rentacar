/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TipoPersona;
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
import inacap.webcomponent.rentacar.repository.TipoPersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository tipopersonaRepository;
    
    @GetMapping()
    public Iterable<TipoPersona> list() {
        return tipopersonaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersona> get(@PathVariable String id) {
        Optional<TipoPersona> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        TipoPersona cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersona> put(@PathVariable String id, @RequestBody TipoPersona tipopersonaEditar) {
        Optional<TipoPersona> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        TipoPersona cEncontrado = cOptional.get();
        tipopersonaEditar.setIdPersona(cEncontrado.getIdPersona());
        
        tipopersonaRepository.save(tipopersonaEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoPersona nuevoTipoPersona) {
        
        nuevoTipoPersona = tipopersonaRepository.save(nuevoTipoPersona);
        Optional<TipoPersona> cOptional = tipopersonaRepository.findById(nuevoTipoPersona.getIdPersona());
        if(cOptional.isPresent()){
        TipoPersona cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoPersona> cOptional = tipopersonaRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                TipoPersona cEncontrado = cOptional.get();
                
                tipopersonaRepository.deleteById(cEncontrado.getIdPersona());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
