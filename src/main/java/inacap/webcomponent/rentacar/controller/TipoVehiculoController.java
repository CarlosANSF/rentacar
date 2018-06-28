/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TipoVehiculo;
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
import inacap.webcomponent.rentacar.repository.TipoVehiculoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/tipovehiculo")
public class TipoVehiculoController {
    
    @Autowired
    private TipoVehiculoRepository tipovehiculoRepository;
    
    @GetMapping()
    public Iterable<TipoVehiculo> list() {
        return tipovehiculoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculo> get(@PathVariable String id) {
        Optional<TipoVehiculo> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        TipoVehiculo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> put(@PathVariable String id, @RequestBody TipoVehiculo tipovehiculoEditar) {
        Optional<TipoVehiculo> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
        
        if(cOptional.isPresent()){
        TipoVehiculo cEncontrado = cOptional.get();
        tipovehiculoEditar.setIdTipoVehiculo(cEncontrado.getIdTipoVehiculo());
        
        tipovehiculoRepository.save(tipovehiculoEditar);
        return new ResponseEntity<>(cEncontrado, HttpStatus.FOUND);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculo nuevoTipoVehiculo) {
        
        nuevoTipoVehiculo = tipovehiculoRepository.save(nuevoTipoVehiculo);
        Optional<TipoVehiculo> cOptional = tipovehiculoRepository.findById(nuevoTipoVehiculo.getIdTipoVehiculo());
        if(cOptional.isPresent()){
        TipoVehiculo cEncontrado = cOptional.get();
        
        return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
        }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoVehiculo> cOptional = tipovehiculoRepository.findById(Integer.parseInt(id));
            if(cOptional.isPresent()){
                TipoVehiculo cEncontrado = cOptional.get();
                
                tipovehiculoRepository.deleteById(cEncontrado.getIdTipoVehiculo());
                
                return new ResponseEntity<>(cEncontrado, HttpStatus.OK);
            }else{
        
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    
    }
}
