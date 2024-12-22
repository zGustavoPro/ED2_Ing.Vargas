/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Arboles;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Arbol p=new Arbol();
      // ListasArboles p2=new ListasArboles(10);
        
        p.insertar(10);
        p.insertar(5);
        p.insertar(15);
        p.insertar(3);
        p.insertar(7);
        p.insertar(18);
        p.insertar(13);
        
      /*  p.inOrden();
        System.out.println("");
        p.preOrden();
        System.out.println("");
        p.postOrden();
        System.out.println("descendente");
        p.desc();
        System.out.println(p.seEncuentra(20));
        System.out.println(p.cantidad());
        System.out.println(p.suma());
        System.out.println(p.mayor());
        p.mostrarTerm();
        System.out.println(p.cantidadTerm());
        System.out.println(p.Lineal());  */
     p.inOrden();
        System.out.println("valor eliminado completamente");
       p.eliminarPares();
        p.inOrden();
     
     
    }//end main.
}//end.
