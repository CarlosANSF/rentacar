/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;


public class Marca {
    
    private int idMarca;
    
    private String nombreMarca;
    
    private String detalle;
    
    public static ArrayList<Marca> marca = new ArrayList<>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Marca() {
    }

    public Marca(String nombreMarca, String detalle) {
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }

    private Marca(int idMarca, String nombreMarca, String detalle) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalle = detalle;
    }
    
    public boolean nuevoMarca(Marca marcanuevo){
        
        int id = 0;
        if(!marca.isEmpty()){
            for(Marca a : marca){
                if(a.getIdMarca()> id){
                    id = a.getIdMarca();
                }
            }  
        }
        id++;
        marca.add(new Marca(id, marcanuevo.getNombreMarca(), marcanuevo.getDetalle()));
        return true;
    }
    
    
    
     public Marca buscarMarca(int id){
        
        Marca marcaEncontrado = null;
        
        if(!marca.isEmpty()){
            for(Marca a: marca){
                if(a.getIdMarca()==id){
                    marcaEncontrado = a;
                }
            }
        }
        return marcaEncontrado;
    }
     
     
     public Marca editarMarca(int id, Marca marcaEditar){
        Marca marcaEditado = null;
        
        if(!marca.isEmpty()){
            for(Marca a: marca){
                if(a.getIdMarca()== id){
                    a.setNombreMarca(marcaEditar.getNombreMarca());
                    a.setDetalle(marcaEditar.getDetalle());
                    
                    marcaEditado = a;
                }
            }
        }
        return marcaEditado;
    }

   public boolean eliminarMarca(int id){
       Marca marcaEliminada = null;
       
       if(!marca.isEmpty()){
           for(Marca a : marca){
               if(a.getIdMarca()==id){
                   marcaEliminada = a;
               }
           }
       }
       marca.remove(marcaEliminada);
       return true;
   }
    
    
    
}
