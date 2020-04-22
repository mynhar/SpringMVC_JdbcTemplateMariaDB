/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynharcorp.modelo.persona;

/**
 *
 * @author Harold M Bonilla L
 */
public class Persona {
    
    private int id;
    private String nombre;
    private String correo;    
    private int pais;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String correo, int pais, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Persona(int id, String nombre, String correo, int pais, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
        this.telefono = telefono;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
