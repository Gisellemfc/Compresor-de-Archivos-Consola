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
public class Contexto {
     private EstrategiaCompresor estrategiaCompresor;

    public Contexto(EstrategiaCompresor estrategiaCompresor){
        this.estrategiaCompresor = estrategiaCompresor;
    }

    public double ejecutarEstrategia(double tamano){
        return estrategiaCompresor.comprimir(tamano);
    }
}
