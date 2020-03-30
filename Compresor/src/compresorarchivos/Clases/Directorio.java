/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivos.Clases;

import java.util.ArrayList;

/**
 *
 * @author Giselle Ferreira
 */
public class Directorio {
    private String nombre;
    private double tamano;
    private ArrayList<Archivo> conjuntoArchivos;

    public Directorio(String nombre) {
        this.nombre = nombre;
        tamano = 0;
        conjuntoArchivos = new ArrayList<Archivo>();
    }
    
    public void agregarArchivo(Archivo archivo){
        tamano = tamano + archivo.getTamano();
        conjuntoArchivos.add(archivo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public ArrayList<Archivo> getConjuntoArchivos() {
        return conjuntoArchivos;
    }

    public void setConjuntoArchivos(ArrayList<Archivo> conjuntoArchivos) {
        this.conjuntoArchivos = conjuntoArchivos;
    }
    
    
    
}
