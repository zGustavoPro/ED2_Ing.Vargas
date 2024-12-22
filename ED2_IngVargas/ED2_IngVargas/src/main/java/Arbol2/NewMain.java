/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arbol2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      ListasArbolesString arbol=new ListasArbolesString(3);
      arbol.arbol[0].insertar("hola");
      arbol.arbol[0].insertar("pedro");
      arbol.arbol[0].insertar("como");
      
      arbol.arbol[1].insertar("estas");
      arbol.arbol[1].insertar("buenas");
      arbol.arbol[1].insertar("noches");
      
      arbol.arbol[2].insertar("buenos");
      arbol.arbol[2].insertar("dias");
      arbol.arbol[2].insertar("hola");
      
      arbol.mostrar();
      
      List<String> L2 = new ArrayList<>();
      L2.add("pedro");
      L2.add("hola");
      L2.add("buenas");
      L2.add("dias");
      arbol.eliminar(L2);
      arbol.mostrar();
     
    }//end main
    
}//end class
