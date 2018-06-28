/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.repository;

import inacap.webcomponent.rentacar.model.Traccion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 19725847-0
 */
public interface TraccionRepository extends CrudRepository<Traccion, Integer> {
    
}
