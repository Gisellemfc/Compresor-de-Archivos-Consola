/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivos.Clases;

/**
 *
 * @author Giselle Ferreira
 */
public class Archivo {
    private String nombre;
    private String tipo;
    private double tamano;

    public Archivo(String nombre, String tipo, double tamano) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
    
}
