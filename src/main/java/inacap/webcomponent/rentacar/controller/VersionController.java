/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

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
import inacap.webcomponent.rentacar.model.Version;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/version")
public class VersionController {
    
     @GetMapping()
    public List<Version> list() {
        return Version.version;
    }
    
    @GetMapping("/{id}")
    public Version get(@PathVariable String id) {
        Version version = new Version();
        
        return version.BuscarVersion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Version nuevoVersion) {
        
        Version version = new Version();
        
        if(!version.nuevaVersion(nuevoVersion)){
            return new ResponseEntity<>(HttpStatus.CREATED);
                    
        }else
        
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Version version = new Version();
        if(!version.eliminarVersion(Integer.parseInt(id))){
            return new ResponseEntity<>(HttpStatus.OK);
            
        }else
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    
}
