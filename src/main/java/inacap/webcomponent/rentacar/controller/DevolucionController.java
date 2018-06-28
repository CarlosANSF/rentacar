/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Devolucion;
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
import inacap.webcomponent.rentacar.repository.DevolucionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 


@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
    
    @Autowired
    private DevolucionRepository devolucionRepository;
    
    @GetMapping()
    public Iterable<Devolucion> list() {
        return devolucionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Devolucion> get(@PathVariable String id) {
        Optional<Devolucion> cOptional = devolucionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Devolucion cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Devolucion> put(@PathVariable String id, @RequestBody Devolucion devolucionEditar) {
        Optional<Devolucion> cOptional = devolucionRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        Devolucion cEncontrado = cOptional.get();
        devolucionEditar.setIdDevolucion(cEncontrado.getIdDevolucion());
        
        devolucionRepository.save(devolucionEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Devolucion nuevoDevolucion) {
        
        nuevoDevolucion = devolucionRepository.save(nuevoDevolucion);
        Optional<Devolucion> cOptional = devolucionRepository.findById(nuevoDevolucion.getIdDevolucion());
        if(cOptional.isPresent()){
        Devolucion cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<Devolucion> cOptional = devolucionRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                Devolucion cEncontrado = cOptional.get();
                
                devolucionRepository.deleteById(cEncontrado.getIdDevolucion());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
