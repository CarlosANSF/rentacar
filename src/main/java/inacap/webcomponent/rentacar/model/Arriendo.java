/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arriendo")
public class Arriendo {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    private Persona vendedor;
    private Persona cliente;
    private Vehiculo vehiculo;
    private MedioPago mediopago;

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MedioPago getMediopago() {
        return mediopago;
    }

    public void setMediopago(MedioPago mediopago) {
        this.mediopago = mediopago;
    }

    public Arriendo() {
    }

    public Arriendo(Date fechaArriendo, Time horaArriendo, Persona vendedor, Persona cliente, Vehiculo vehiculo, MedioPago mediopago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.mediopago = mediopago;
    }

    private Arriendo(int idArriendo, Date fechaArriendo, Time horaArriendo, Persona vendedor, Persona cliente, Vehiculo vehiculo, MedioPago mediopago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.mediopago = mediopago;
    }
}
    


    
    

    

    

