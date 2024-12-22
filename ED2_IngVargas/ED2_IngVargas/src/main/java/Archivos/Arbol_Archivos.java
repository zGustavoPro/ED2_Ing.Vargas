/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import Arbol2.Arbol2;
/**
 *
 * @author zGustavoIbarraz
 */
public class Arbol_Archivos {
   private String nom; 
   public Arbol2 arbol;
   
    public Arbol_Archivos(int lineaXPag,String archivo) {
        this.nom = archivo;
        arbol=new Arbol2(lineaXPag);
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void procesarArchivo() {
        File archivo = new File(nom);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 1;

            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split("\\W+"); 
                for (String palabra : palabras) {
                    if (!esIrrelevante(palabra)) {
                        arbol.insertar(palabra.toLowerCase(), numeroLinea);  
                    }
                }
                numeroLinea++;
            }
            arbol.mostrarAscendente();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    private boolean esIrrelevante(String palabra) {
        Set<String> irrelevantes = new HashSet<>(Arrays.asList("el", "la", "los", "las", "de", "y", "a", "que", "en", "por", "para"," "));
        return irrelevantes.contains(palabra.toLowerCase());
    }

//Pruebas
    
    public void crearArchivo() {
        File archivo = new File(nom);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
        }
    }
    
public void escribirArchivo() {
        File archivo = new File(nom);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe,Primero Cree el Archivo ");
            return;
        }
        
        try (FileWriter escritor = new FileWriter(archivo, true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escriba el contenido del archivo. Presione '0' para salir.");
            String linea;

            while (true) {
                linea = scanner.nextLine();
                if ("0".equals(linea)) {
                    break;  
                }
                escritor.write(linea + "\n");
            }
            System.out.println("Texto guardado exitosamente en el archivo.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
        }
    }
   
    public void leerArchivo() {
        File archivo = new File(nom);

        try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferedReader = new BufferedReader(lector)) {

            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + archivo.getName());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
        }
    }
  
}
