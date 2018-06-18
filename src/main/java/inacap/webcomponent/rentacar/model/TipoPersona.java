/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class TipoPersona {
    
    private int idPersona;
    
    private String nombreTipoPersona;
    
    private String detalle;
    
    public static ArrayList<TipoPersona> tipopersona = new ArrayList<>();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoPersona() {
    }

    public TipoPersona(String nombreTipoPersona, String detalle) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }

    private TipoPersona(int idPersona, String nombreTipoPersona, String detalle) {
        this.idPersona = idPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalle = detalle;
    }
    
     public boolean nuevoTipoPersona(TipoPersona tipopersonanuevo){
        
        int id = 0;
        if(!tipopersona.isEmpty()){
            for(TipoPersona a : tipopersona){
                if(a.getIdPersona()> id){
                    id = a.getIdPersona();
                }
            }  
        }
        id++;
        tipopersona.add(new TipoPersona(id, tipopersonanuevo.getNombreTipoPersona(), tipopersonanuevo.getDetalle()));
        return true;
    }
    
    
    
     public TipoPersona buscarTipoPersona(int id){
        
        TipoPersona tipopersonaEncontrado = null;
        
        if(!tipopersona.isEmpty()){
            for(TipoPersona a: tipopersona){
                if(a.getIdPersona()==id){
                    tipopersonaEncontrado = a;
                }
            }
        }
        return tipopersonaEncontrado;
    }
     
     
     public TipoPersona editarTipoPersona(int id, TipoPersona tipopersonaEditar){
        TipoPersona tipopersonaEditado = null;
        
        if(!tipopersona.isEmpty()){
            for(TipoPersona a: tipopersona){
                if(a.getIdPersona()== id){
                    a.setNombreTipoPersona(tipopersonaEditar.getNombreTipoPersona());
                    a.setDetalle(tipopersonaEditar.getDetalle());
                    
                    tipopersonaEditado = a;
                }
            }
        }
        return tipopersonaEditado;
    }

   public boolean eliminarTipoPersona(int id){
       TipoPersona tipopersonaEliminada = null;
       
       if(!tipopersona.isEmpty()){
           for(TipoPersona a : tipopersona){
               if(a.getIdPersona()==id){
                   tipopersonaEliminada = a;
               }
           }
       }
       tipopersona.remove(tipopersonaEliminada);
       return true;
   }
    
    
    
}
