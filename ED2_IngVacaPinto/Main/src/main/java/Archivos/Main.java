/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Archivos;

import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       ArchivosTxT arch=new ArchivosTxT();
       arch.setNom("Uagrm.txt");
       arch.crearArchivo();
       arch.leerArchivo(); 
    }
    
}
