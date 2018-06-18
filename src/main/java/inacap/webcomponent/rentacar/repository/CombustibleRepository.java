/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.repository;

import org.springframework.data.repository.CrudRepository;
import inacap.webcomponent.rentacar.model.Combustible;


/**
 *
 * @author 19168534-2
 */
public interface CombustibleRepository extends CrudRepository<Combustible, Integer> {
    
}
