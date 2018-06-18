/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class Carroceria {
    
    private int idCarroceria;
    
    private String nombreCarroceria;
    
    private String detalle;
    
    public static ArrayList<Carroceria> carroceria = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Carroceria() {
    }

    public Carroceria(String nombreCarroceria, String detalle) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }

    private Carroceria(int idCarroceria, String nombreCarroceria, String detalle) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalle = detalle;
    }
    
    
     public boolean nuevoCarroceria(Carroceria carrocerianuevo){
        
        int id = 0;
        if(!carroceria.isEmpty()){
            for(Carroceria a : carroceria){
                if(a.getIdCarroceria()> id){
                    id = a.getIdCarroceria();
                }
            }  
        }
        id++;
        carroceria.add(new Carroceria(id, carrocerianuevo.getNombreCarroceria(), carrocerianuevo.getDetalle()));
        return true;
    }
    
    
    
     public Carroceria buscarCarroceria(int id){
        
        Carroceria carroceriaEncontrado = null;
        
        if(!carroceria.isEmpty()){
            for(Carroceria a: carroceria){
                if(a.getIdCarroceria()==id){
                    carroceriaEncontrado = a;
                }
            }
        }
        return carroceriaEncontrado;
    }
     
     
     public Carroceria editarCarroceria(int id, Carroceria carroceriaEditar){
        Carroceria carroceriaEditado = null;
        
        if(!carroceria.isEmpty()){
            for(Carroceria a: carroceria){
                if(a.getIdCarroceria() == id){
                    a.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                    a.setDetalle(carroceriaEditar.getDetalle());
                    
                    carroceriaEditado = a;
                }
            }
        }
        return carroceriaEditado;
    }

   public boolean eliminarCarroceria(int id){
       Carroceria carroceriaEliminada = null;
       
       if(!carroceria.isEmpty()){
           for(Carroceria a : carroceria){
               if(a.getIdCarroceria()==id){
                   carroceriaEliminada = a;
               }
           }
       }
       carroceria.remove(carroceriaEliminada);
       return true;
   }
    
    
    
}


