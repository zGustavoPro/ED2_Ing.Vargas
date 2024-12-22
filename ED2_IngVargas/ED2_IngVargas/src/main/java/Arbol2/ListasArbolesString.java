/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol2;

import java.util.*;

/**
 *
 * @author zGustavoIbarraz
 */
public class ListasArbolesString {
    public Arbol_String[] arbol;
    public int max;
    
    public ListasArbolesString(int max){
        this.max = max;
        arbol = new Arbol_String[max]; 
        for (int i = 0; i < this.max; i++) {
            arbol[i] = new Arbol_String(); 
        }   
    }
    
    public void eliminar(List<String> L2){
        for (int i = 0; i < this.max; i++) {
            for (String pal : L2) {
                arbol[i].eliminar(pal);
            }
        }
    }

    public void mostrar(){
        for (int i = 0; i < this.max; i++) {
            arbol[i].inOrden();
            System.out.println(" ");
        }
    }
    
    public void eliminarNodosRaices() {
        for (int i = 0; i < this.max; i++) {
            arbol[i].raiz = null; // Elimina la raíz del árbol
        }
    }
    
     public void eliminarNodosTerm() {
        for (int i = 0; i < this.max; i++) {
            arbol[i].raiz = eliminarNodosTerm(arbol[i].raiz); 
        }
    }

    private Nodo2 eliminarNodosTerm(Nodo2 p) {
        if (p == null) return null;
        if (p.izq == null && p.der == null) {
            return null;
        }
        p.izq = eliminarNodosTerm(p.izq);
        p.der = eliminarNodosTerm(p.der);

        return p; 
    }
    
}//end.
