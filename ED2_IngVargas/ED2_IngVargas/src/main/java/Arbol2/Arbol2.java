/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol2;

import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

/**
 *
 * @author usuario
 */
public class Arbol2 {
    private Nodo2 raiz;
    private final int LineasPorPagina;
    
    public Arbol2(int n){
        raiz = null;
        this.LineasPorPagina=n;
    }  
    
    public void insertar(String x,int linea){
        raiz = insertar(x,linea, raiz);
    }
    
    private Nodo2 insertar(String x, int linea ,Nodo2 p){
        if (p == null) {
            Nodo2 nuevoNodo =new Nodo2(x);
            nuevoNodo.lineas.add(linea);
            nuevoNodo.paginas.add((linea-1)/this.LineasPorPagina+1);
            return nuevoNodo;
        }
        
        if (x.equals(p.ele)) {
            p.lineas.add(linea);
            p.paginas.add((linea-1)/this.LineasPorPagina+1);
            p.frec++;
            return p;
        }
        
        if (x.compareTo(p.ele) < 0) {
            p.izq = insertar(x,linea,p.izq);  
        } else {
            p.der = insertar(x,linea,p.der);
        }
        return p;
    }
    
    public void mostrarAscendente() {
        mostrarAscendente(raiz);
    }

    private void mostrarAscendente(Nodo2 p) {
        if (p != null) {
            mostrarAscendente(p.izq);
            System.out.println("Palabra: " + p.ele +" | Frecuencia: " + p.frec+" | Linea: "+p.lineas+" | Pagina: "+p.paginas);
            mostrarAscendente(p.der);
        }
    }

    public void mostrarDescendente() {
        mostrarDescendente(raiz);
    }

    private void mostrarDescendente(Nodo2 p) {
        if (p != null) {
            mostrarDescendente(p.der);
            System.out.println("Palabra: " + p.ele +" | Frecuencia: " + p.frec+" | Linea: "+p.lineas+" | Pagina: "+p.paginas);
            mostrarDescendente(p.izq);
        }
    }
    
    public List<String> obtenerPalabrasOrdenadasPorFrecuencia() {
        List<String> lista = new ArrayList<>();
        obtenerPalabrasOrdenadasPorFrecuencia(raiz, lista);
        return lista;
    }

    private void obtenerPalabrasOrdenadasPorFrecuencia(Nodo2 p, List<String> lista) {
        if (p != null) {
            obtenerPalabrasOrdenadasPorFrecuencia(p.izq, lista);
            lista.add(p.ele + ": " + p.frec);
            obtenerPalabrasOrdenadasPorFrecuencia(p.der, lista);
        }
    }
    
}//end.
