/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;


import java.util.ArrayList;


public class Traccion {
    
    private int idTraccion;
    
    private String nombreTraccion;
    
    private String detalle;
    
    
    public static ArrayList<Traccion> traccion = new ArrayList<>();

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Traccion() {
    }

    public Traccion(String nombreTraccion, String detalle) {
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }

    private Traccion(int idTraccion, String nombreTraccion, String detalle) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalle = detalle;
    }
    
    
     public boolean nuevoTraccion(Traccion traccionnuevo){
        
        int id = 0;
        if(!traccion.isEmpty()){
            for(Traccion a : traccion){
                if(a.getIdTraccion()> id){
                    id = a.getIdTraccion();
                }
            }  
        }
        id++;
        traccion.add(new Traccion(id, traccionnuevo.getNombreTraccion(), traccionnuevo.getDetalle()));
        return true;
    }
    
    
    
     public Traccion buscarTraccion(int id){
        
        Traccion traccionEncontrado = null;
        
        if(!traccion.isEmpty()){
            for(Traccion a: traccion){
                if(a.getIdTraccion() ==id){
                    traccionEncontrado = a;
                }
            }
        }
        return traccionEncontrado;
    }
     
     
     public Traccion editarTraccion(int id, Traccion traccionEditar){
        Traccion traccionEditado = null;
        
        if(!traccion.isEmpty()){
            for(Traccion a: traccion){
                if(a.getIdTraccion() == id){
                    a.setNombreTraccion(traccionEditar.getNombreTraccion());
                    a.setDetalle(traccionEditar.getDetalle());
                    
                    traccionEditado = a;
                }
            }
        }
        return traccionEditado;
    }

   public boolean eliminarTraccion(int id){
       Traccion traccionEliminada = null;
       
       if(!traccion.isEmpty()){
           for(Traccion a : traccion){
               if(a.getIdTraccion()==id){
                   traccionEliminada = a;
               }
           }
       }
       traccion.remove(traccionEliminada);
       return true;
   }
    
    
    
}
