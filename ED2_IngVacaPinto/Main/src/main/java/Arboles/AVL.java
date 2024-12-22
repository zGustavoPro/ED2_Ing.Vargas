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
public class AVL <K extends Comparable<K>,V> extends ArbolBinarioBusqueda<K,V>{
   
    @Override
    public void insertarR(K claveAInsertar, V valorAInsertar ){
     this.raiz=insertarR(this.raiz, claveAInsertar,valorAInsertar );
    }
   
     private NodoBinario<K,V> insertarR(NodoBinario<K,V> nodoActual,K claveAInsertar, V valorAInsertar ){ //recursivo
         if ( claveAInsertar==null || valorAInsertar==null ) {
          throw new IllegalArgumentException(" La Clave  o el Valor No Puede ser null ");
         }  
          if(NodoBinario.esNodoVacio(nodoActual)){
            NodoBinario<K,V> nuevoNodo=new NodoBinario<>(claveAInsertar,valorAInsertar);
            return nuevoNodo;
         } 
           if(claveAInsertar.compareTo(nodoActual.getClave())<0){
               NodoBinario<K,V> nuevoHijoIzq=insertarR(nodoActual.getHijoIzquierdo(),claveAInsertar,valorAInsertar);
              nodoActual.setHijoIzquierdo(nuevoHijoIzq);
              //balancear
              return nodoActual;
          } else if(claveAInsertar.compareTo(nodoActual.getClave())>0) {
              NodoBinario <K,V> nuevoHijoDer=insertarR(nodoActual.getHijoDerecho(),claveAInsertar,valorAInsertar);
            nodoActual.setHijoDerecho(nuevoHijoDer);
            //balamcear
            return nodoActual;
          }else{
            throw new IllegalArgumentException(" valor ya Existe");  
          }
     }
     
     
     
}//end.
