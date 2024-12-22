/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;
import java.io.*;
import java.io.BufferedReader;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class ArchivosTxT {
  private String nom; 
  
  public ArchivosTxT(){
   nom="ED2.txt";
  }
  
  public void setNom(String nom){
      this.nom=nom;
  }
  
  public void crearArchivo() throws IOException{
      File archivo=new File(nom);
      try (Scanner scanner = new Scanner(System.in)) {
          if(archivo.createNewFile()){
              System.out.println("Archivo creado :"+archivo.getName());
          } else {
              System.out.println("El Archivo ya Existe");
          }
          
          try (FileWriter escritor = new FileWriter(nom)) {
              String linea;
              System.out.println("presione 0 para salir");
              while(true){
                  linea=scanner.nextLine();
                  if(linea.equals("0")){
                      break;
                  }
                  escritor.write(linea+"\n");
              }
          }
      }
      System.out.println("Archivo Guardado");
  }
  
  public void leerArchivo() throws FileNotFoundException, IOException{
      File archivo=new File(nom);
      try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferedReader = new BufferedReader(lector)) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
        }
    }
  
  
}//end.
