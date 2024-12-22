/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Arboles;

public class Main {

    public static void main(String[] args) {
       ArbolBinarioBusqueda <Integer,String> arbolito = new ArbolBinarioBusqueda<>();
       arbolito.insertar(22,"cafe");
       arbolito.insertar(23,"pedro");
       arbolito.insertar(21,"maria");
       arbolito.insertar(25,"juan");
       arbolito.insertar(19,"mendez");
       
        System.out.println(arbolito);
        System.out.println(arbolito.recorridoPosOrden());
      arbolito.eliminarNodo(23);
      System.out.println(arbolito.recorridoPosOrden());
    }
}
