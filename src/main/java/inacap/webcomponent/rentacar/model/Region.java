/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class Region {
    
    private int idRegion;
    
    private String nombreRegion;
    
    private String detalle;
    
    public static ArrayList<Region> region = new ArrayList<>();

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Region() {
    }

    public Region(String nombreRegion, String detalle) {
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }

    private Region(int idRegion, String nombreRegion, String detalle) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
        this.detalle = detalle;
    }
    
    public boolean nuevoRegion(Region regionnuevo){
        
        int id = 0;
        if(!region.isEmpty()){
            for(Region a : region){
                if(a.getIdRegion()> id){
                    id = a.getIdRegion();
                }
            }  
        }
        id++;
        region.add(new Region(id, regionnuevo.getNombreRegion(), regionnuevo.getDetalle()));
        return true;
    }
    
    
    
     public Region buscarRegion(int id){
        
        Region regionEncontrado = null;
        
        if(!region.isEmpty()){
            for(Region a: region){
                if(a.getIdRegion()==id){
                    regionEncontrado = a;
                }
            }
        }
        return regionEncontrado;
    }
     
     
     public Region editarRegion(int id, Region regionEditar){
        Region regionEditado = null;
        
        if(!region.isEmpty()){
            for(Region a: region){
                if(a.getIdRegion()== id){
                    a.setNombreRegion(regionEditar.getNombreRegion());
                    a.setDetalle(regionEditar.getDetalle());
                    
                    regionEditado = a;
                }
            }
        }
        return regionEditado;
    }

   public boolean eliminarRegion(int id){
       Region regionEliminada = null;
       
       if(!region.isEmpty()){
           for(Region a : region){
               if(a.getIdRegion()==id){
                   regionEliminada = a;
               }
           }
       }
       region.remove(regionEliminada);
       return true;
   }
    
    
     
     
    
    
}
