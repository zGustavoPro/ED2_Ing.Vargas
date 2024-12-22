/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos2;

/**
 *
 * @author usuario
 */
public class Nodo2 {
    public Nodo2 ant;
      public String elem;
    public Nodo2 prox;
    
    public Nodo2 (Nodo2 ant,String elem,Nodo2 prox){
        this.ant=ant;
        this.elem=elem;
        this.prox=prox;
    }
    
    
}
