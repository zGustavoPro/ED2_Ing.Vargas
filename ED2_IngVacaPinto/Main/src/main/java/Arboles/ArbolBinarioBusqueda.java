/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;
//import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArbolBinarioBusqueda <K extends Comparable<K>,V> implements IArbolBusqueda<K,V>  {

     protected NodoBinario<K,V> raiz;
     
    @Override
    public void vaciar() {
      this.raiz= (NodoBinario<K,V>)NodoBinario.nodoVacio();//null
    }

    @Override
    public boolean esArbolVacio() {
      return NodoBinario.esNodoVacio(raiz);
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) { //iterativo
     if (claveAInsertar==null){
         throw new IllegalArgumentException("Valor no puede ser nulo");
     }
     if (valorAInsertar==null){
         throw new IllegalArgumentException("Valor no puede ser nulo");
     }
     
     if (this.esArbolVacio()){
      this.raiz=new NodoBinario<>(claveAInsertar,valorAInsertar);
      return;
     }
     
     NodoBinario<K,V> nodoActual=this.raiz; 
     NodoBinario<K,V> nodoAnterior=(NodoBinario<K,V>)NodoBinario.nodoVacio();
     
     while(!NodoBinario.esNodoVacio(nodoActual)){
         K claveActual=nodoActual.getClave();
         nodoAnterior = nodoActual;
         if(claveAInsertar.compareTo(claveActual)<0){
         nodoActual=nodoActual.getHijoIzquierdo();
         }else if(claveAInsertar.compareTo(claveActual)>0){
             nodoActual=nodoActual.getHijoDerecho();
         }else {
             nodoActual.setValor(valorAInsertar);
             return;
         }
     }
     NodoBinario<K,V> nuevoNodo=new NodoBinario<>(claveAInsertar,valorAInsertar);
     K claveDelPadre=nodoAnterior.getClave();
     if (claveAInsertar.compareTo(claveDelPadre)<0){
         nodoAnterior.setHijoIzquierdo(nuevoNodo);
     }else {
         nodoAnterior.setHijoDerecho(nuevoNodo);
         
     }
    }
    @Override
    public void insertarR(K clave,V valor){
      this.raiz=insertarR(raiz,clave,valor);  
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
    
    @Override
    public boolean contiene(K clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<K> recorridoPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public List<K> recorridoPosOrden() {
    List<K> recorrido = new ArrayList<>(); 
    if (!this.esArbolVacio()){
        Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
        NodoBinario<K,V> nodoActual=this.raiz;
        this.meterEnPilaParaPosOrden(nodoActual, pilaDeNodos);
        while(!pilaDeNodos.isEmpty()){
        nodoActual=pilaDeNodos.pop();
        recorrido.add(nodoActual.getClave());
        if (!pilaDeNodos.isEmpty()){
            NodoBinario<K,V> nodoDelTope = pilaDeNodos.peek();
            if(!nodoDelTope.esVacioHijoDerecho()
               && nodoDelTope.getHijoDerecho() != nodoActual ){
                this.meterEnPilaParaPosOrden(nodoDelTope.getHijoDerecho(),pilaDeNodos);
          }
        }
      }
    }
    return recorrido;
    }
    
    @Override
   public void meterEnPilaParaPosOrden(NodoBinario <K,V> nodoActual,Stack <NodoBinario<K,V>> pilaDeNodos){
        
        while(!NodoBinario.esNodoVacio(nodoActual)){
          pilaDeNodos.push(nodoActual);
          if (!nodoActual.esVacioHijoIzquierdo()){
              nodoActual=nodoActual.getHijoIzquierdo();
          } else {
              nodoActual= nodoActual.getHijoDerecho();
          }
        }
    }    

    @Override
    public void eliminarNodo(K claveAEliminar){
        raiz=eliminarNodo(raiz,claveAEliminar);
    }
    private NodoBinario<K,V> eliminarNodo(NodoBinario<K,V> nodoActual,K claveAEliminar) {
     if ( claveAEliminar==null || NodoBinario.esNodoVacio(nodoActual)) {
          throw new IllegalArgumentException(" La Clave  o el Valor No Puede ser null ");
         }  
         
           if(claveAEliminar.compareTo(nodoActual.getClave())<0){
               NodoBinario<K,V> nuevoHijoIzq=eliminarNodo(nodoActual.getHijoIzquierdo(),claveAEliminar);
              nodoActual.setHijoIzquierdo(nuevoHijoIzq);
              return nodoActual;
          } else if(claveAEliminar.compareTo(nodoActual.getClave())>0) {
              NodoBinario <K,V> nuevoHijoDer=eliminarNodo(nodoActual.getHijoDerecho(),claveAEliminar);
            nodoActual.setHijoDerecho(nuevoHijoDer);
            //balamcear
            return nodoActual;
          } 
           
         if(nodoActual.esHoja()){
            return null; 
         }
         if(!nodoActual.esNodoCompleto()&& !nodoActual.esHoja()){
           if(!nodoActual.esVacioHijoDerecho())
               return nodoActual.getHijoDerecho();
           else
               return nodoActual.getHijoIzquierdo();
         }
         
        NodoBinario<K,V> nodoRemplazo=BuscarSucesorInOrden(nodoActual);
        K claveRemplazo=nodoRemplazo.getClave();
        V valorRemplazo=nodoRemplazo.getValor();
        nodoActual=eliminarNodo(nodoActual,claveRemplazo);
        nodoActual.setClave(claveRemplazo);
        nodoActual.setValor(valorRemplazo);
       return nodoActual;
    }
    
   private NodoBinario <K,V> BuscarSucesorInOrden(NodoBinario<K,V> nodoActual){
      if(nodoActual.esVacioHijoDerecho())
      {          return null;   }
      NodoBinario<K,V> nodoSucesor=nodoActual.getHijoDerecho();
      while(!nodoSucesor.esVacioHijoIzquierdo()){
          nodoSucesor=nodoSucesor.getHijoIzquierdo();
      }
      return nodoSucesor;
      
   }
    
}//End.

  
 


