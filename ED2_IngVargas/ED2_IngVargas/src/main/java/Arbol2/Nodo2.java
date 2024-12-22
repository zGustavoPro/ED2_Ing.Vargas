/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Nodo2 {
    public Nodo2 izq,der;
    public String ele;
    public int frec;
    public List<Integer> lineas;
    public List<Integer> paginas;
    
 public Nodo2(String x){
    this.izq=this.der=null;
    this.ele=x;
    this.frec=1;
    
    this.lineas = new ArrayList<>();
    this.paginas = new ArrayList<>();
 } 
 
}//End.
