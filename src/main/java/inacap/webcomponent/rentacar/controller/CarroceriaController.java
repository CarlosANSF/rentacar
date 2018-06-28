/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Carroceria;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.rentacar.model.Carroceria;
import org.springframework.http.HttpStatus;
import inacap.webcomponent.rentacar.repository.CarroceriaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
    @Autowired
    private CarroceriaRepository carroceriaRepository;
    
    @GetMapping()
    public Iterable<Carroceria> list() {
        return carroceriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Carroceria> get(@PathVariable String id) {
        Optional<Carroceria> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Carroceria cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Carroceria> put(@PathVariable String id, @RequestBody Carroceria carroceriaEditar) {
        Optional<Carroceria> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Carroceria cEncontrado = cOptional.get();
        carroceriaEditar.setIdCarroceria(cEncontrado.getIdCarroceria());
        
        carroceriaRepository.save(carroceriaEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Carroceria nuevoCarroceria) {
        
        nuevoCarroceria = carroceriaRepository.save(nuevoCarroceria);
        Optional<Carroceria> cOptional = carroceriaRepository.findById(nuevoCarroceria.getIdCarroceria());
        if(cOptional.isPresent()){
        Carroceria cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Carroceria> cOptional = carroceriaRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Carroceria cEncontrado = cOptional.get();
                
                carroceriaRepository.deleteById(cEncontrado.getIdCarroceria());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
