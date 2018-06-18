/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class Modelo {
    
    private int idModelo;
    
    private String nombreModelo;
    
    private String detalle;
    
    private Marca marca;
    
    public static ArrayList<Modelo> modelo = new ArrayList<>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo() {
    }

    public Modelo(String nombreModelo, String detalle, Marca marca) {
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }

    private Modelo(int idModelo, String nombreModelo, String detalle, Marca marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalle = detalle;
        this.marca = marca;
    }
    
    public boolean nuevoModelo(Modelo modelonuevo){
        
        int id = 0;
        if(!modelo.isEmpty()){
            for(Modelo a : modelo){
                if(a.getIdModelo()> id){
                    id = a.getIdModelo();
                }
            }  
        }
        id++;
        modelo.add(new Modelo(id, modelonuevo.getNombreModelo(), modelonuevo.getDetalle(), modelonuevo.getMarca()));
        return true;
    }
    
    
    
     public Modelo buscarModelo(int id){
        
        Modelo modeloEncontrado = null;
        
        if(!modelo.isEmpty()){
            for(Modelo a: modelo){
                if(a.getIdModelo()==id){
                    modeloEncontrado = a;
                }
            }
        }
        return modeloEncontrado;
    }
     
     
     public Modelo editarModelo(int id, Modelo modeloEditar){
        Modelo modeloEditado = null;
        
        if(!modelo.isEmpty()){
            for(Modelo a: modelo){
                if(a.getIdModelo()== id){
                    a.setNombreModelo(modeloEditar.getNombreModelo());
                    a.setDetalle(modeloEditar.getDetalle());
                    a.setMarca(modeloEditar.getMarca());
                    
                    modeloEditado = a;
                }
            }
        }
        return modeloEditado;
    }

   public boolean eliminarModelo(int id){
       Modelo modeloEliminada = null;
       
       if(!modelo.isEmpty()){
           for(Modelo a : modelo){
               if(a.getIdModelo()==id){
                   modeloEliminada = a;
               }
           }
       }
       modelo.remove(modeloEliminada);
       return true;
   }
    
    
    
}
