/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Arbol {
public Nodo raiz;
public Arbol(){
    raiz=null;
}

public void generarElem(int n,int a,int b){
    for(int i=0; i<n; i++){
     int num= ThreadLocalRandom.current().nextInt(a,b+1);
     this.insertar(num);
    }
}

public void insertar(int x){
 raiz=insertar(x,raiz);   
}

private Nodo insertar(int x,Nodo p){
 if(p==null)return new Nodo(x);
 if(x<p.elem)
   p.izq=insertar(x,p.izq);
 else  p.der=insertar(x,p.der);
 return p;
}

public void preOrden(){
    preOrden(raiz);
}
private void preOrden(Nodo p){
   if(p==null)return;
    System.out.println(p.elem);
   preOrden(p.izq);
   preOrden(p.der);
}

public void inOrden(){
inOrden(raiz);    
}
private void inOrden(Nodo p){
   if(p==null)return;
   inOrden(p.izq);
    System.out.println(p.elem);
    inOrden(p.der);
}public void postOrden() {
    postOrden(raiz);
}

private void postOrden(Nodo p) {
    if (p == null) return;
    postOrden(p.izq);  
    postOrden(p.der);  
    System.out.println(p.elem);  
}

public void desc(){
    desc(raiz);
}

private void desc(Nodo p){
 if(p==null)return;
   desc(p.der);
    System.out.println(p.elem);
    desc(p.izq);
}

public boolean seEncuentra(int x){
  return seEncuentra(x,raiz);   
}

private boolean seEncuentra(int x,Nodo p) {
if(p==null)return false; 
if(p.elem==x)return true; else
  return seEncuentra(x,p.izq) || seEncuentra(x,p.der);   
}

public int cantidad(){
    return cantidad(raiz);
}

private int cantidad(Nodo p){
if(p==null) return 0;
else
     return cantidad(p.izq)+cantidad(p.der)+1;
}    
    
public int suma(){
  return suma(raiz);  
}

private int suma(Nodo p){
if(p==null)return 0;
return p.elem+suma(p.izq)+suma(p.der);
}
    
 public int mayor(){
     if(raiz==null) { throw new IllegalStateException("Arbol Vacio"); }
     return mayor(raiz);    
 }   
    
 private int mayor(Nodo p){
 while(p.der != null){
     p=p.der;
 }
 return p.elem;
 }   
  
 public int menor(){
     if(raiz==null) { throw new IllegalStateException("Arbol Vacio"); }
     return menor(raiz);    
 }   
    
 private int menor(Nodo p){
 while(p.izq != null){
     p=p.izq;
 }
 return p.elem;
 }   
  
 public void preOrden(List<Integer> L1) {
    preOrden(raiz, L1);
     System.out.println(L1);
}

private void preOrden(Nodo p, List<Integer> L1) {
    if (p != null) {
        L1.add(p.elem); 
        preOrden(p.izq, L1); 
        preOrden(p.der, L1); 
    }
}

 public void inOrden(List<Integer> L1) {
    inOrden(raiz, L1);
     System.out.println(L1);
}

private void inOrden(Nodo p, List<Integer> L1) {
    if (p != null) {
        inOrden(p.izq, L1); 
        L1.add(p.elem); 
        inOrden(p.der, L1); 
    }
}

 public void postOrden(List<Integer> L1) {
    postOrden(raiz, L1);
     System.out.println(L1);
}

private void postOrden(Nodo p, List<Integer> L1) {
    if (p != null) {
        postOrden(p.izq, L1); 
        postOrden(p.der, L1); 
        L1.add(p.elem); 
    }
}

public void niveles(List<Integer> L1) {
    if (raiz == null) {
        return; 
    }
    Queue<Nodo> queue = new LinkedList<>(); 
    queue.add(raiz); 
    while (!queue.isEmpty()) {
        Nodo current = queue.poll(); 
        L1.add(current.elem); 
        if (current.izq != null) {
            queue.add(current.izq);
        }
        if (current.der != null) {
            queue.add(current.der);
        }
    }
}

public void mostrarConNivel() {
    mostrarConNivel(raiz, 0); 
}

private void mostrarConNivel(Nodo p, int nivel) {
    if (p != null) {
        mostrarConNivel(p.izq, nivel + 1); 
        System.out.println("Elemento: " + p.elem + ", Nivel: " + nivel);
        mostrarConNivel(p.der, nivel + 1); 
    }
}

public void elemNivel(){
    elemNivel(raiz,0);
}
private void elemNivel(Nodo p,int nivel){
  if(p==null)return;
elemNivel(p.izq,nivel+1);
    System.out.println(p.elem+"\t"+ nivel);
    elemNivel(p.der,nivel+1);
}

public void mostrarNiveles(){
 LinkedList <Nodo> L1 = new LinkedList();
 if(raiz != null)L1.add(raiz);
 while(!L1.isEmpty()){
   Nodo p=L1.removeFirst();
   if(p.izq != null) L1.add(p.izq);
   if(p.der != null) L1.add(p.der);
     System.out.println(p.elem);
 }
}







 //tarea
 public void mostrarTerm(){
     ArrayList<Integer> L1 = new ArrayList<>();
        encontrarTerminales(raiz, L1);
        Collections.sort(L1); 
        System.out.println("Nodos terminales en orden de menor a mayor: " + L1);    
 }   
 
 private void encontrarTerminales(Nodo p,ArrayList<Integer> L1){
  if (p == null) return; 
        if (p.izq == null && p.der == null) {
            L1.add(p.elem); 
        } else {
            encontrarTerminales(p.izq,L1);
            encontrarTerminales(p.der,L1);
        }   
 }
    
 public int cantidadTerm(){
 return this.cantidadTerm(raiz);
 }   
   
private int cantidadTerm(Nodo p){
    if(p==null) return 0;
    if(p.izq==null && p.der==null)
     return 1; 
       return cantidadTerm(p.izq) + cantidadTerm(p.der);      
} 

public boolean Lineal() {
    return esLineal(raiz);
}

private boolean esLineal(Nodo p) {
    if (p == null) return true; 
    if (p.izq != null && p.der != null) {
        return false; 
    }
    return esLineal(p.izq) && esLineal(p.der);
}

public Integer inmediatoSup(int x) {
    Nodo nodoX = buscarNodo(raiz, x);
    if (nodoX == null) {
        return x; 
    }
    Nodo sup = encontrarInmediatoSuperior(nodoX);
    return (sup != null) ? sup.elem : x; // if (sup != null)? return sup.elem else return x;
}
private Nodo buscarNodo(Nodo p, int x) {
    if (p == null) return null; 
    if (p.elem == x) return p; 
    return (x < p.elem)? buscarNodo(p.izq, x) : buscarNodo(p.der, x); 
}

private Nodo encontrarInmediatoSuperior(Nodo p) {
    if (p.der != null) {
        return encontrarMinimo(p.der);
    }
    return null; 
}

private Nodo encontrarMinimo(Nodo p) {
    while (p.izq != null) {
        p = p.izq; 
    }
    return p; 
}

//eliminar

public void eliminar(int x){
 raiz=eliminar(x,raiz);   
}

private Nodo eliminar(int x,Nodo p){
    if (p==null) return null;
    
    if ( x==p.elem) return eliminarNodo(p);
    
    if (x<p.elem)
        p.izq=eliminar(x,p.izq);
    else 
        p.der=eliminar(x,p.der);
    return p;
}

private Nodo eliminarNodo(Nodo p){
    if (p.izq==null && p.der==null) return null; 
    if (p.izq == null && p.der != null) return p.der;
    if (p.der == null && p.izq != null)  return p.izq;
  
    Nodo q=p.der;
    
    while(q.izq != null) {
        q=q.izq;
    }
    p.elem=q.elem;
     return eliminar(q.elem,p.der);   
    
}

public void eliminarHojas() {
        raiz = eliminarHojas(raiz);
    }

    private Nodo eliminarHojas(Nodo p) {
      if (p==null) return null;
      if (p.izq==null && p.der==null)return null;
      p.izq=eliminarHojas(p.izq);
      p.der=eliminarHojas(p.der);
      return p;
    }

    public void eliminarPares() {
        raiz = eliminarPares(raiz);
    }
    private Nodo eliminarPares(Nodo p) {
        if (p == null) return null;
        p.izq = eliminarPares(p.izq);
        p.der = eliminarPares(p.der);
        return (p.elem % 2 == 0)? eliminarNodo(p) : p; 
        
    }

public void eliminarSup(int x) {
    raiz = eliminarSup(x, raiz);
}

private Nodo eliminarSup(int x, Nodo p) {
    if (p == null) return null;
    if (x == p.elem) {
        if (p == raiz) {
            Nodo sup = p.der;
            while (sup != null && sup.izq != null) sup = sup.izq;
            return eliminar(sup.elem, raiz);
        }
        return eliminarNodo(p);
    }
    if (x < p.elem) {
        p.izq = eliminarSup(x, p.izq);
    } else {
        p.der = eliminarSup(x, p.der);
    }
    return p;
}

public void eliminarInf(int x) {
    raiz = eliminarInf(x, raiz);
}
private Nodo eliminarInf(int x, Nodo p) {
    if (p == null) return null;
    if (x == p.elem) { 
        if (p == raiz) {
            Nodo inf = p.izq;
            while (inf != null && inf.der != null) inf = inf.der;
            return eliminar(inf.elem, raiz);
        }
        return eliminarNodo(p);
    }
    if (x < p.elem) {
        p.izq = eliminarInf(x, p.izq);
    } else {
        p.der = eliminarInf(x, p.der);
    }
    return p;
}

public void eliminarMenor() {
    if (raiz != null) {
        raiz = eliminar(menor(), raiz);
    }
}

public void eliminarMayor() {
    if (raiz != null) {
        raiz = eliminar(mayor(), raiz);
    }
}

public void eliminar(List<Integer> L1){
  for (int x : L1){
    eliminar(x);
  }  
}

private Nodo unirHijos(Nodo p) {
    if (p.izq == null) return p.der; 
    if (p.der == null) return p.izq;     
    Nodo min = encontrarMinimo(p.der);
    p.elem = min.elem; 
    p.der = eliminar(min.elem, p.der);
    return p;
}

public void eliminarNivel(int n){
  raiz=eliminarNivel(raiz,0,n);  
}

private Nodo eliminarNivel(Nodo p,int nivelActual,int n ){
  if (p == null) return null;

    if (nivelActual == n) {
        return unirHijos(p); 
    }
    p.izq = eliminarNivel(p.izq, nivelActual + 1, n);
    p.der = eliminarNivel(p.der, nivelActual + 1, n);
    return p; 
}

public void eliminarRaices() {
    while (raiz != null) {
        raiz = eliminarNodo(raiz); 
    }
}


}//end.
