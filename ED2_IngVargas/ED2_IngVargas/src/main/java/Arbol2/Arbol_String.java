
package Arbol2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zGustavoIbarraz
 */
public class Arbol_String {
    public Nodo2 raiz;
    
    public Arbol_String(){
        raiz = null;   
    }
    
    public void insertar(String pal){
        raiz = insertar(pal, raiz);   
    }

    private Nodo2 insertar(String pal, Nodo2 p){
        if (p == null) return new Nodo2(pal);

        if (pal.length() < p.ele.length())
            p.izq = insertar(pal, p.izq);
        else
            p.der = insertar(pal, p.der);
        
        return p;
    }
    
 public void inOrden(){
     inOrden(raiz);    
  }
   private void inOrden(Nodo2 p){
     if(p==null)return;
       inOrden(p.izq);
        System.out.println(p.ele);
       inOrden(p.der);
     }

    // Eliminar
    
    public void eliminar(String pal){
        raiz = eliminar(pal, raiz);   
    }

    private Nodo2 eliminar(String pal, Nodo2 p){
        if (p == null) return null;

        if (pal.equals(p.ele)) return eliminarNodo(p);  

        if (pal.length() < p.ele.length())
            p.izq = eliminar(pal, p.izq);
        else 
            p.der = eliminar(pal, p.der);

        return p;
    }

    private Nodo2 eliminarNodo(Nodo2 p){
        if (p.izq == null && p.der == null) return null; 
        if (p.izq == null && p.der != null) return p.der;
        if (p.der == null && p.izq != null) return p.izq;
      
        Nodo2 q = p.der;
        
        while (q.izq != null) {
            q = q.izq;
        }
        
        p.ele = q.ele;
        return eliminar(q.ele, p.der);   
    }


}//end.