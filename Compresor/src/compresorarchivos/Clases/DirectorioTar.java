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
public class DirectorioTar implements EstrategiaCompresor{

    @Override
    public double comprimir(double tamano) {
        return tamano * (0.75d);
    }
    
}
