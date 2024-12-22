/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

/**
 *
 * @author usuario
 * @param <K>
 * @param <V>
 */

public class NodoBinario <K,V>{ //clave,Valor
    private K clave;
    private V valor;
    private NodoBinario <K,V>hijoIzquierdo;
    private NodoBinario <K,V>hijoDerecho;

   //Constructor 
    public NodoBinario(K clave,V valor){
        this.clave=clave;
        this.valor=valor;
    }

    public K getClave() {
        return this.clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public NodoBinario<K, V> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<K, V> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }
    public boolean esVacioHijoDerecho(){
     return NodoBinario.esNodoVacio(this.hijoDerecho);
    }
        
     public boolean esVacioHijoIzquierdo(){
       return NodoBinario.esNodoVacio(this.hijoIzquierdo);
    }
     
    public NodoBinario<K,V> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<K, V> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esNodoCompleto(){
        return !this.esVacioHijoDerecho() && !this.esVacioHijoIzquierdo();
    }
    
    public static boolean esNodoVacio(NodoBinario nodo){
        return nodo==nodoVacio();//sin static NodoBinario.nodoVacio
    }
    
    public static NodoBinario<?,?> nodoVacio(){
    return null;
   } 
    
    public boolean esHoja(){
        return this.esVacioHijoDerecho()&& this.esVacioHijoIzquierdo();
    }
    
}

