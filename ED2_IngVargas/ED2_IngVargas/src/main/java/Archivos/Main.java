/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Archivos;

/**
 *
 * @author zGustavoIbarraz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String nom="C:\\Universidad_Gustavo\\2-2024\\E.Datos 2\\ED2_IngVargas\\Directorio_de_Archivos\\Startup.txt";
       int n=10;
       Arbol_Archivos arch=new Arbol_Archivos(n,nom);
       arch.procesarArchivo();
    }
    
}//end.
