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
@Table(name = "version")
public class Version {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idVersion;
    private String nobre;
    private String detalle;
    private int puertas;
    private int pasajeros;
    private float cilindrada;
    private float rendimiento;
    private int capacidad;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierrecentralizado;
    private boolean alzavidrios;
    private boolean camararetro;
    private Combustible combustible;
    private Carroceria carroceria;
    private Transmision transmision;
    private Traccion traccion;
    private Modelo modelo;
    

    public Version() {
    }

    public Version(String nobre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidad, int airbags, boolean aireAcondicionado, boolean cierrecentralizado, boolean alzavidrios, boolean camararetro, Combustible combustible, Carroceria carroceria, Transmision transmision, Traccion traccion, Modelo modelo) {
        this.nobre = nobre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidad = capacidad;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierrecentralizado = cierrecentralizado;
        this.alzavidrios = alzavidrios;
        this.camararetro = camararetro;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    private Version(int idVersion, String nobre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidad, int airbags, boolean aireAcondicionado, boolean cierrecentralizado, boolean alzavidrios, boolean camararetro, Combustible combustible, Carroceria carroceria, Transmision transmision, Traccion traccion, Modelo modelo) {
        this.idVersion = idVersion;
        this.nobre = nobre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidad = capacidad;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierrecentralizado = cierrecentralizado;
        this.alzavidrios = alzavidrios;
        this.camararetro = camararetro;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNobre() {
        return nobre;
    }

    public void setNobre(String nobre) {
        this.nobre = nobre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCierrecentralizado() {
        return cierrecentralizado;
    }

    public void setCierrecentralizado(boolean cierrecentralizado) {
        this.cierrecentralizado = cierrecentralizado;
    }

    public boolean isAlzavidrios() {
        return alzavidrios;
    }

    public void setAlzavidrios(boolean alzavidrios) {
        this.alzavidrios = alzavidrios;
    }

    public boolean isCamararetro() {
        return camararetro;
    }

    public void setCamararetro(boolean camararetro) {
        this.camararetro = camararetro;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public Traccion getTraccion() {
        return traccion;
    }

    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    } 
    
    
}