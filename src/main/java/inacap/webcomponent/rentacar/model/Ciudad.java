/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idCiudad;
    
    private String nombreCiudad;
    
    private String detalle;
    
    private Region region;
    

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Ciudad() {
    }

    public Ciudad(String nombreCiudad, String detalle, Region region) {
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }

    private Ciudad(int idCiudad, String nombreCiudad, String detalle, Region region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalle = detalle;
        this.region = region;
    }
    
   
}
