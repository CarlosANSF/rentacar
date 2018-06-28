/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.MedioPago;
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
import inacap.webcomponent.rentacar.repository.MedioPagoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/mediopago")
public class MedioPagoController {
    
    @Autowired
    private MedioPagoRepository medioPagoRepository;
    
    @GetMapping()
    public Iterable<MedioPago> list() {
        return medioPagoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MedioPago> get(@PathVariable String id) {
        Optional<MedioPago> cOptional = medioPagoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        MedioPago cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPago> put(@PathVariable String id, @RequestBody MedioPago medioPagoEditar) {
        Optional<MedioPago> cOptional = medioPagoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        MedioPago cEncontrado = cOptional.get();
        medioPagoEditar.setIdMedioPago(cEncontrado.getIdMedioPago());
        
        medioPagoRepository.save(medioPagoEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MedioPago nuevoMedioPago) {
        
        nuevoMedioPago = medioPagoRepository.save(nuevoMedioPago);
        Optional<MedioPago> cOptional = medioPagoRepository.findById(nuevoMedioPago.getIdMedioPago());
        if(cOptional.isPresent()){
        MedioPago cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MedioPago> cOptional =medioPagoRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                MedioPago cEncontrado = cOptional.get();
                
                medioPagoRepository.deleteById(cEncontrado.getIdMedioPago());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
