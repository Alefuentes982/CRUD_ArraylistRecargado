/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudalumnos;

/**
 *
 * @author Laboratorio
 */
public class Alumno {
    
    private String rut;
    private String nombre;
    private byte edad;

    public Alumno() {
    }

    public Alumno(String rut, String nombre, byte edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return rut + ", " + nombre + ", " + edad;
    }
    
    
    
    
    
}
