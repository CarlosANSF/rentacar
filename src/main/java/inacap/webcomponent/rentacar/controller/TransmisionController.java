/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.Combustible;
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


@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    @GetMapping()
    public List<Transmision> list() {
        return Transmision.transmision;
    }
    
    @GetMapping("/{id}")
    public Transmision get(@PathVariable String id) {
        Transmision transmision = new Transmision();
        
        return transmision.buscarTransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transmision nuevoTransmision) {
        
        Transmision transmision = new Transmision();
        
        if(!transmision.nuevoTransmision(nuevoTransmision)){
            return new ResponseEntity<>(HttpStatus.CREATED);
                    
        }else
        
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Transmision transmision = new Transmision();
        if(!transmision.eliminarTransmision(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
            
        }else
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    
}
