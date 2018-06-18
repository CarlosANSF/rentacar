/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;


import java.util.ArrayList;


public class TipoVehiculo {
    
    private int idTipoVehiculo;
    
    private String nombreTipoVehiculo;
    
    private String detalle;
    
    public static ArrayList<TipoVehiculo> tipovehiculo = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoVehiculo() {
    }

    public TipoVehiculo(String nombreTipoVehiculo, String detalle) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }

    private TipoVehiculo(int idTipoVehiculo, String nombreTipoVehiculo, String detalle) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalle = detalle;
    }
    
    
   public boolean nuevoTipoVehiculo(TipoVehiculo tipovehiculonuevo){
        
        int id = 0;
        if(!tipovehiculo.isEmpty()){
            for(TipoVehiculo a : tipovehiculo){
                if(a.getIdTipoVehiculo()> id){
                    id = a.getIdTipoVehiculo();
                }
            }  
        }
        id++;
        tipovehiculo.add(new TipoVehiculo(id, tipovehiculonuevo.getNombreTipoVehiculo(), tipovehiculonuevo.getDetalle()));
        return true;
    }
    
    
    
     public TipoVehiculo buscarTipoVehiculo(int id){
        
        TipoVehiculo tipovehiculoEncontrado = null;
        
        if(!tipovehiculo.isEmpty()){
            for(TipoVehiculo a: tipovehiculo){
                if(a.getIdTipoVehiculo()==id){
                    tipovehiculoEncontrado = a;
                }
            }
        }
        return tipovehiculoEncontrado;
    }
     
     
     public TipoVehiculo editarTipoVehiculo(int id, TipoVehiculo tipovehiculoEditar){
        TipoVehiculo tipovehiculoEditado = null;
        
        if(!tipovehiculo.isEmpty()){
            for(TipoVehiculo a: tipovehiculo){
                if(a.getIdTipoVehiculo() == id){
                    a.setNombreTipoVehiculo(tipovehiculoEditar.getNombreTipoVehiculo());
                    a.setDetalle(tipovehiculoEditar.getDetalle());
                    
                    tipovehiculoEditado = a;
                }
            }
        }
        return tipovehiculoEditado;
    }

   public boolean eliminarTipoVehiculo(int id){
       TipoVehiculo tipovehiculoEliminada = null;
       
       if(!tipovehiculo.isEmpty()){
           for(TipoVehiculo a : tipovehiculo){
               if(a.getIdTipoVehiculo()==id){
                   tipovehiculoEliminada = a;
               }
           }
       }
       tipovehiculo.remove(tipovehiculoEliminada);
       return true;
   }
    
    
}    
    

