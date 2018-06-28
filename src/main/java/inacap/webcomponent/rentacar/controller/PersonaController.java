/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Persona;
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
import inacap.webcomponent.rentacar.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping()
    public Iterable<Persona> list() {
        return personaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Persona> get(@PathVariable String id) {
        Optional<Persona> cOptional = personaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Persona cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Persona> put(@PathVariable String id, @RequestBody Persona personaEditar) {
        Optional<Persona> cOptional = personaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Persona cEncontrado = cOptional.get();
        personaEditar.setIdPersona(cEncontrado.getIdPersona());
        
        personaRepository.save(personaEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Persona nuevoPersona) {
        
        nuevoPersona = personaRepository.save(nuevoPersona);
        Optional<Persona> cOptional = personaRepository.findById(nuevoPersona.getIdPersona());
        if(cOptional.isPresent()){
        Persona cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Persona> cOptional = personaRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Persona cEncontrado = cOptional.get();
                
                personaRepository.deleteById(cEncontrado.getIdPersona());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
