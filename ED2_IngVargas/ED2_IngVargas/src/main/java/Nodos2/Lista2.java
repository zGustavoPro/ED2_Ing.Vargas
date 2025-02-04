/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos2;

/**
 *
 * @author usuario
 */
public class Lista2 { //Lista doble
    
    public int cantElem;
    public Nodo2 prim;
    public Nodo2 ult;

    public Lista2() {
        this.cantElem = 0;
        this.prim = this.ult = null;
    }

      @Override
    public String toString(){
        String s="[";
        Nodo2 p=this.prim;
        while (p!=null){
            s=s+p.elem;
            if(p.prox!=null){
                s=s+",";
            }
             p=p.prox;
        } 
    return s+"]";
    }

    public boolean vacio() {
    return this.prim == null;
}

    public void insertarUlt(String x) {
        if (vacio()) {
            this.prim = this.ult = new Nodo2(null, x, null);
        } else {
            this.ult.prox = new Nodo2(this.ult, x, null);
            this.ult = this.ult.prox;
        }
        this.cantElem++;
    }

    public void insertarPrim(String x) {
        if (vacio()) {
            this.prim = this.ult = new Nodo2(null, x, null);
        } else {
            this.prim = new Nodo2(null, x, this.prim);
            this.prim.prox.ant = this.prim;
        }
        this.cantElem++;
    }
/*
    public void insertarIesimo(int x, int i) {
        if (i < 0 || i > cantElem) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo2 p = this.prim, op = null;
        int k = 0;

        while (p != null && k != i) {
            op = p;
            p = p.prox;
            k++;
        }
        insertarNodo(x, op, p);
    }

    private void insertarNodo(int x, Nodo2 op, Nodo2 p) {
        Nodo2 nuevo = new Nodo2(op, x, p);
        if (op == null) {
            this.prim = nuevo;
        } else {
            op.prox = nuevo;
        }
        if (p != null) {
            p.ant = nuevo;
        } else {
            this.ult = nuevo;
        }
        this.cantElem++;
    }

    public void insertarLugar(int x) {
        Nodo2 p = prim, op = null;
        while (p != null && x > p.elem) {
            op = p;
            p = p.prox;
        }
        insertarNodo(x, op, p);
    }
*/
    public void ordenarAsc() {
        if (vacio()) return;
        for (Nodo2 p = this.prim; p != null; p = p.prox) {
            Nodo2 menor = p;
            for (Nodo2 p2 = p; p2 != null; p2 = p2.prox) {
                if (p2.elem.length() < menor.elem.length()) {
                    menor = p2;
                }
            }
            String aux = p.elem;
            p.elem = menor.elem;
            menor.elem = aux;
        }
    }

    public void ordenarDesc() {
        if (vacio()) return;
        for (Nodo2 p = this.prim; p != null; p = p.prox) {
            Nodo2 mayor = p;
            for (Nodo2 p2 = p; p2 != null; p2 = p2.prox) {
                if (p2.elem.length() > mayor.elem.length()) {
                    mayor = p2;
                }
            }
            String aux = p.elem;
            p.elem = mayor.elem;
            mayor.elem = aux;
        }
    }
/*
    public void insertarLugarDesc(int x) {
        insertarUlt(x);
        ordenarDesc();
    }

    public void insertarLugarAsc(int x) {
        insertarUlt(x);
        ordenarAsc();
    }

    public void insertarIesimo(Lista2 L2, int i) {
        if (L2.vacio()) return;
        Nodo2 p = L2.prim;
        while (p != null) {
            this.insertarIesimo(p.elem, i);
            p = p.prox;
        }
    }

    public void insertarPrim(Lista2 L2) {
        if (L2.vacio()) return;
        Nodo2 p = L2.prim;
        while (p != null) {
            this.insertarPrim(p.elem);
            p = p.prox;
        }
    }

    public void insertarUltI(Lista2 L2) {
        if (L2.vacio()) return;
        Nodo2 p = L2.prim;
        while (p != null) {
            this.insertarUlt(p.elem);
            p = p.prox;
        }
    }

    public boolean iguales() {
        if (this.prim == null) {
            return true;
        }
        Nodo2 p = this.prim;
        while (p != null) {
            if (p.elem != this.prim.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean diferentes() {
        Nodo2 p1 = this.prim;
        while (p1 != null) {
            Nodo2 p2 = p1.prox;
            while (p2 != null) {
                if (p1.elem == p2.elem) {
                    return false;
                }
                p2 = p2.prox;
            }
            p1 = p1.prox;
        }
        return true;
    }

    public boolean ascendente() {
        if (vacio()) return false;
        Nodo2 p = this.prim;
        while (p.prox != null) {
            if (p.elem > p.prox.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean descendente() {
        if (vacio()) return false;
        Nodo2 p = this.prim;
        while (p.prox != null) {
            if (p.elem < p.prox.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

    public boolean ordenado() {
        return ascendente() || descendente();
    }

    public int indexOf(int x) {
        Nodo2 p = this.prim;
        int pos = 0;
        while (p != null) {
            if (p.elem == x)
                return pos;
            pos++;
            p = p.prox;
        }
        return -1;
    }

    public Nodo2 direccion(int n) {
        Nodo2 p = this.prim;
        for (int i = 0; i < n && p != null; i++) {
            p = p.prox;
        }
        return p;
    }

    public void invertir() {
        if (vacio()) return;
        Nodo2 p = this.prim;
        for (int i = 0; i < cantElem / 2; i++) {
            int aux = p.elem;
            Nodo2 p2 = direccion(cantElem - i - 1);
            p.elem = p2.elem;
            p2.elem = aux;
            p = p.prox;
        }
    }

    public Nodo2 lastIndexOf(int x) {
        Nodo2 last = null;
        Nodo2 p = this.prim;
        while (p != null) {
            if (p.elem == x) {
                last = p;
            }
            p = p.prox;
        }
        return last;
    }

    public boolean esPalindromo() {
        if (vacio()) return true;

        Lista2 listaAux = new Lista2();
        Nodo2 p = this.prim;

        while (p != null) {
            listaAux.insertarUlt(p.elem);
            p = p.prox;
        }

        listaAux.invertir();
        Nodo2 original = this.prim;
        Nodo2 invertida = listaAux.prim;

        while (original != null && invertida != null) {
            if (original.elem != invertida.elem) {
                return false;
            }
            original = original.prox;
            invertida = invertida.prox;
        }
        return true;
    }
    //LABORATORIO 9
    public void eliminarPrim() {
    if (vacio()) return;
    if (this.prim == this.ult) {
        this.prim = this.ult = null;
    } else {
        this.prim = this.prim.prox;
        this.prim.ant = null;
    }
    cantElem--;
}

public void eliminarUlt() {
    if (vacio()) return;
    if (this.prim == this.ult) {
        this.prim = this.ult = null;
    } else {
        this.ult = this.ult.ant;
        this.ult.prox = null;
    }
    cantElem--;
}

    
    public Nodo2 eliminarNodo(Nodo2 ant, Nodo2 p) {
    if (ant == null) {
        eliminarPrim();
        return this.prim;
    }
    if (p.prox == null) {
        eliminarUlt();
        return null;
    }
    p.prox.ant = ant;
    ant.prox = p.prox;
    cantElem--;
    return ant.prox;
}

     
     public void eliminarTodo(int x) {
    Nodo2 p = this.prim, ant = null;
    while (p != null) {
        if (p.elem == x) {
            p = eliminarNodo(ant, p);
        } else {
            ant = p;
            p = p.prox;
        }
    }
}

     
     public void eliminarPrimN(int n){
         for (int i=1; i<=n; i++){
             eliminarPrim();
         }  
       }
     public void eliminarUltN(int n){
         for (int i=1; i<=n; i++){
             eliminarUlt();
         }  
       }
      public Nodo2 Direccion(int n){
           Nodo2 p = this.prim;
         for (int i = 1; i < n && p != null; i++) {  p = p.prox; }
         return p;
          }
     public void eliminarIesimo(int x){
         if (x<0 || x>cantElem)return;
         if (x==1)
             eliminarPrim();
         else {
             Nodo2 p=Direccion(x-1);
             p.prox=p.prox.prox;
             cantElem--;
         } 
       }
      public int frecuencia(int x){
        Nodo2 p=this.prim;
        int c=0;
        while (p != null){
            if (p.elem==x)
                c++;
             p=p.prox;
        }
        return c; 
    }
      public void eliminarUnicos(){
          Nodo2 p=this.prim;
          while (p != null){
              if (frecuencia(p.elem)==1){
              eliminarTodo(p.elem);
              p=this.prim;
              } else
              p=p.prox;
          }
       }
      
     public void eliminarDuplicados() {
    if (vacio()) return;
    Nodo2 p = this.prim;
    while (p != null) {
        if (this.frecuencia(p.elem) > 1) {
            eliminarTodo(p.elem); 
            p = this.prim;  
        } else {
            p = p.prox;
        }
    }
}

    
     public void eliminar(Lista2 L2){
          if (L2.vacio()) return;
           Nodo2 p=L2.prim;
         while (p != null){
             eliminarTodo(p.elem);
             p=p.prox;
         }
       }
  */ 
}//end.
