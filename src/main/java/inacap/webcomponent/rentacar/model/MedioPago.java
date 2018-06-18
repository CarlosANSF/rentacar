/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class MedioPago {
    
    private int idMedioPago;
    
    private String nombreMedioPago;
    
    private String detalle;
    
    public static ArrayList<MedioPago> mediopago = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public MedioPago() {
    }

    public MedioPago(String nombreMedioPago, String detalle) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }

    private MedioPago(int idMedioPago, String nombreMedioPago, String detalle) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalle = detalle;
    }
    
    public boolean nuevoMedioPago(MedioPago mediopagonuevo){
        
        int id = 0;
        if(!mediopago.isEmpty()){
            for(MedioPago a : mediopago){
                if(a.getIdMedioPago()> id){
                    id = a.getIdMedioPago();
                }
            }  
        }
        id++;
        mediopago.add(new MedioPago(id, mediopagonuevo.getNombreMedioPago(), mediopagonuevo.getDetalle()));
        return true;
    }
    
    
    
     public MedioPago buscarMedioPago(int id){
        
        MedioPago mediopagoEncontrado = null;
        
        if(!mediopago.isEmpty()){
            for(MedioPago a: mediopago){
                if(a.getIdMedioPago()==id){
                    mediopagoEncontrado = a;
                }
            }
        }
        return mediopagoEncontrado;
    }
     
     
     public MedioPago editarMedioPago(int id, MedioPago mediopagoEditar){
        MedioPago mediopagoEditado = null;
        
        if(!mediopago.isEmpty()){
            for(MedioPago a: mediopago){
                if(a.getIdMedioPago()== id){
                    a.setNombreMedioPago(mediopagoEditar.getNombreMedioPago());
                    a.setDetalle(mediopagoEditar.getDetalle());
                    
                    mediopagoEditado = a;
                }
            }
        }
        return mediopagoEditado;
    }

   public boolean eliminarMedioPago(int id){
       MedioPago mediopagoEliminada = null;
       
       if(!mediopago.isEmpty()){
           for(MedioPago a : mediopago){
               if(a.getIdMedioPago()==id){
                   mediopagoEliminada = a;
               }
           }
       }
       mediopago.remove(mediopagoEliminada);
       return true;
   }
    
}
