/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Arboles;

/**
 *
 * @author usuario
 */
import java.util.List;
import java.util.Stack;


public interface IArbolBusqueda <K extends Comparable <K>,V> {
    
 void vaciar();   
 boolean esArbolVacio();
 void insertar(K clave,V valor);
 void insertarR(K clvae,V valor);
 boolean contiene(K clave);
 List<K>recorridoPreOrden();
 List<K>recorridoPosOrden();
 void meterEnPilaParaPosOrden(NodoBinario <K,V> nodoActual,Stack <NodoBinario<K,V>> pilaDeNodos);
 //metodos de ELiminar
 void eliminarNodo(K clave);
}
