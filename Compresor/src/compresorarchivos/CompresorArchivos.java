/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compresorarchivos;

import compresorarchivos.Clases.Archivo;
import compresorarchivos.Clases.Contexto;
import compresorarchivos.Clases.Directorio;
import compresorarchivos.Clases.DirectorioRar;
import compresorarchivos.Clases.DirectorioTar;
import compresorarchivos.Clases.DirectorioZip;
import compresorarchivos.Clases.EstrategiaCompresor;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Giselle Ferreira
 */
public class CompresorArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean seleccionando = true;
        
        System.out.println("Bienvenido al sistema de compresión de archivos del Equipo 1.");
        
        System.out.println("Por favor ingrese el nombre de su directorio:");
        String nombre = sc.nextLine();
        Directorio comprimido = new Directorio(nombre);
        
        System.out.println("\nPor favor seleccione los archivos que desea comprimir.");
        
        do {            
            JFileChooser filedlg = new JFileChooser();
            filedlg.showOpenDialog(null);
            File selected = filedlg.getSelectedFile();
            System.out.println(selected.getName().substring(selected.getName().lastIndexOf("."),selected.getName().length()));
            Archivo nuevoArchivo = new Archivo(selected.getName(), selected.getName().substring(selected.getName().lastIndexOf("."),selected.getName().length()), selected.length());
            
            comprimido.agregarArchivo(nuevoArchivo);
            
            String res = "";
                    
            do {   
                
                System.out.println("\n¿Desea agregar otro archivo? SI/NO");
                res = sc.nextLine();
                if (res.equalsIgnoreCase("Si")) {
                    seleccionando = true;
                } else if (res.equalsIgnoreCase("No")){
                    seleccionando = false;
                } else{
                    System.out.println("Ingrese una opción válida.");
                }
               
            } while (!res.equalsIgnoreCase("Si") && !res.equalsIgnoreCase("No"));
            
        } while (seleccionando);
        
        String tipo = "";
        
        do {
            
            System.out.println("\n¿Qué tipo de compresión desea? ZIP/TAR/RAR");
            tipo = sc.next();
            
            if (!tipo.equalsIgnoreCase("zip") && !tipo.equalsIgnoreCase("rar") && !tipo.equalsIgnoreCase("tar")) {
                System.out.println("Elija una opción válida.");
            }
            
        } while (!tipo.equalsIgnoreCase("zip") && !tipo.equalsIgnoreCase("rar") && !tipo.equalsIgnoreCase("tar"));
        
        EstrategiaCompresor estrategiaCompresor = obtenerEstrategia(tipo);
        Contexto contexto = new Contexto(estrategiaCompresor);
        System.out.println("\nSu archivo comprimido ha sido generado.");
        System.out.println("Nombre comprimido: " + comprimido.getNombre() + "." + tipo.toLowerCase());
        System.out.println("Tamaño comprimido: " + contexto.ejecutarEstrategia(comprimido.getTamano()));
        System.out.println("Archivos:");
        for (int i = 0; i < comprimido.getConjuntoArchivos().size(); i++) {
            System.out.println("Nombre archivo: " + comprimido.getConjuntoArchivos().get(i).getNombre());
        }

    }
    
    private static EstrategiaCompresor obtenerEstrategia(String tipo) {
        EstrategiaCompresor strategy;
        if (tipo.equalsIgnoreCase("zip")) {
            strategy = new DirectorioZip();
        } else if (tipo.equalsIgnoreCase("rar")) {
            strategy = new DirectorioRar();
        } else {
            strategy = new DirectorioTar();
        }
        return strategy;
    }
    
}
