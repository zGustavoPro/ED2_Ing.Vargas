/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos;

/**
 *
 * @author usuario
 */
public class Lista { //Lista doble
    public int cantElem;
    public Nodo prim;
    public Nodo ult;
    
    public Lista(){
        this.cantElem=0;
        this.prim=this.ult=null;
    }
       @Override
    public String toString(){
        String s="[";
        Nodo p=this.prim;
        while (p!=null){
            s=s+p.elem;
            if(p.prox!=null){
                s=s+",";
            }
             p=p.prox;
        } 
    return s+"]";
    }
    public boolean vacio(){
        return this.cantElem==0;
    }
    public void insertarUlt(int x){
   if (vacio())
       this.prim=this.ult=new Nodo(x,null);
   else this.ult=ult.prox=new Nodo(x,null);
   
   this.cantElem++;
    }
    
    public void insertarPrim(int x){
        if (vacio())
            this.prim=this.ult=new Nodo(x,null);
            else this.prim = new Nodo(x,this.prim);
            this.cantElem++;
        }
        
    public void insertarIesimo(int x,int i){
        
       Nodo p=this.prim,op=null;
       int k=0;
       while(p != null && k != i){
           op=p;
           p=p.prox;
           k++;
       }
         insertarNodo(x,op,p);  
       } 
    public void insertarNodo(int x,Nodo op,Nodo p){
        if (op == null){
            insertarPrim(x);
            return;
        }
        if (p==null){
            insertarUlt(x);
            return;
        }
        op.prox=new Nodo(x,p);
        this.cantElem++;
    }
    public boolean iguales(){
        if (this.prim==null){
            return true;
        }
        Nodo p=this.prim;
        Nodo ant=this.prim;
        while(p != null){
             if (p.elem != ant.elem){
                 return false;
             }
             p=p.prox;
        }
        return true;
    }
    
    public int menorElem(){
        if (vacio()){
            return -1;
        }
            Nodo p=this.prim;
          int menor=p.elem;
            while (p!= null){
                if (p.elem<menor)
                    menor = p.elem;
                p=p.prox;
            }
            return menor;     
    }
    public void reemplazar(int x,int y){
        Nodo p=this.prim;
        while (p != null){
            if (p.elem==x){
                p.elem=y;
            }
            p=p.prox;
        }
    }
    public boolean seEncuentra(int x){
        Nodo p=this.prim;
        while (p != null){
            if (p.elem==x){
                return true;
            }
            p=p.prox;
        }
        return false;
    }
    public int frecuencia(int x){
        Nodo p=this.prim;
        int c=0;
        while (p != null){
            if (p.elem==x)
                c++;
             p=p.prox;
        }
        return c; 
    }
    public boolean diferentes(){
       Nodo p1 = this.prim; 
    while (p1 != null) { 
        Nodo p2 = p1.prox;
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
    public boolean existeFrecuencia(int k){
        Nodo p=this.prim;
        while(p != null){
            Nodo p2=this.prim;
            int c=0;
            while (p2 != null){
                if (p.elem==p2.elem)
                    c++;
                p2=p2.prox;
            }
            if (c==k){
                return true;
            }
            p=p.prox;
        }
        return false;
    }
    
    public boolean poker(){
        Nodo p=this.prim;
        if (vacio()){
            return false;
        }
            int c=0;
            int dist=0;
             while (p != null){
             if (p.elem==this.prim.elem)
                 c++;
             else 
                 dist++;
             p=p.prox;
             }  
              return  cantElem-1==c && dist==1;
            } 
    //laboratorio 6 tarea 
    public boolean ascendente(){
       if (vacio()) return false;
        Nodo p2=this.prim.prox;
        Nodo p=this.prim;
        while (p2 != null){
            if (p.elem >p2.elem )
                return false;
            p=p2;
            p2=p2.prox;
        }
        return true;
    }
    public boolean descendente(){
       if (vacio()) return false;
        Nodo p2=this.prim.prox;
        Nodo p=this.prim;
        while (p2 != null){
            if (p.elem <p2.elem )
                return false;
            p=p2;
            p2=p2.prox;
        }
        return true;
    }
    public boolean ordenado(){
       return ascendente()|| descendente(); 
    }
    public boolean pares(){
        if (vacio())return false;
         Nodo p=this.prim;
         while (p != null){
             if(p.elem % 2 != 0)
                 return false;
             p=p.prox;
         }
         return true;
    }
    public boolean impar(){
        if (vacio())return false;
         Nodo p=this.prim;
         while (p != null){
             if(p.elem % 2 == 0)
                 return false;
             p=p.prox;
         }
         return true;
    }
    public boolean parImpar(){
       return this.existeParImpar();
    }
    public boolean mismaFrecuencia(){
        if (vacio())return false;
        Nodo p=this.prim;
        int c=frecuencia(p.elem);
        while (p != null){
            if (frecuencia(p.elem)!= c)
                return false;
            p=p.prox;
        }
        return true;
    } 
    public boolean todosPares(){
        return pares();
    }
    public boolean existeParImpar(){
        if (vacio()) return false;
        Nodo p=this.prim;
        int par=0;
        int impar=0;
        while(p != null){
            if (p.elem % 2 == 0)
                par++; else impar++;
            p=p.prox;
        } return par >0 && impar > 0;
    }  
      public static boolean espar(int e){
       return e%2==0; 
    }
    public boolean alternos() {
    if (vacio()) return false;     
    Nodo p = this.prim;
    boolean esPar = espar(p.elem);  
    while (p != null) {
        if (espar(p.elem) != esPar) {
            return false;  
        }
        esPar = !esPar; 
        p = p.prox;
    }
    
    return true; 
}
    public void insertarUlt(Lista L2){
        if (L2.vacio())return;
        Nodo p=L2.prim;
        while(p != null){
            this.insertarUlt(p.elem);
            p=p.prox;
        }
    }
    public void OrdenarAsc(){
       if (vacio())return;
       Nodo p=this.prim;
       while (p != null){
           Nodo p2=p;
            Nodo menor=p;
           while (p2 != null){
              if (p2.elem<menor.elem){
                  menor=p2;
              }
              p2=p2.prox;
           } 
           int aux=p.elem;
           p.elem=menor.elem;
           menor.elem=aux;
           p=p.prox;
       }
    }
    public void OrdenarDesc(){
       if (vacio())return;
       Nodo p=this.prim;
       while (p != null){
           Nodo p2=p;
            Nodo mayor=p;
           while (p2 != null){
              if (p2.elem>mayor.elem){
                  mayor=p2;
              }
              p2=p2.prox;
           } 
           int aux=p.elem;
           p.elem=mayor.elem;
           mayor.elem=aux;
           p=p.prox;
       }
    }
    public void insertarLugarDesc(int x){
        insertarUlt(x);
        this.OrdenarDesc();
    }
    public void insertarLugarAsc(int x){
        insertarUlt(x);
        this.OrdenarAsc();
    }
    public void intercalar(Lista L2,Lista L3){
        if(L2.vacio()&& this.vacio())return;
        Nodo k=L2.prim; Nodo j=this.prim;
        while ( k != null || j != null){
        if ( k != null){
            L3.insertarUlt(k.elem);
            k=k.prox;
        } 
        if ( j != null){
            L3.insertarUlt(j.elem);
            j=j.prox;
        } 
        }
    }
    //Laboratorio 7
       public void eliminarPrim(){
         if (vacio()) return;
         if (this.prim==this.ult)
             this.prim=this.ult=null;
         else this.prim=this.prim.prox;
               cantElem--;
       }
       public void eliminarUlt(){
        if (vacio()) return;
        if (this.prim==this.ult) 
            this.prim=this.ult=null;
        else {
            Nodo p=this.prim;
            Nodo ant=null;
            while (p.prox != null){
                ant=p;
                p=p.prox;
            }
            ant.prox=null;
            this.ult=ant;
        }  cantElem--;
       }
     
       public void eliminarTodo(int x){
          Nodo p=this.prim; Nodo ant=null; 
          while (p != null){
              if (p.elem==x)
                 p=eliminarNodo(ant,p); 
              else {
                  ant=p;
                  p=p.prox;
              }
          }
       } 
       public Nodo eliminarNodo(Nodo ant,Nodo p){
        if (ant==null){
            eliminarPrim();
            return this.prim;
        }   else {
            ant.prox=p.prox;
            if (p==this.ult){
                this.ult=ant;
            }
            cantElem--;
            return ant.prox;
        }
       }
       public void eliminarIesimo(int x){
         if (x<0 || x>cantElem)return;
         if (x==1)
             eliminarPrim();
         else {
             Nodo p=Direccion(x-1);
             p.prox=p.prox.prox;
             cantElem--;
         }
         
       }
       public void eliminarPrimN(int n){
         for (int i=1; i<=n; i++){
             eliminarPrim();
         }  
       }
       public Nodo Direccion(int n){
           Nodo p = this.prim;
         for (int i = 1; i < n && p != null; i++) {  p = p.prox; }
         return p;
          }
       public void eliminarEntre(int i,int j){
         if (vacio())return;
           int a=i;
           while (a<=j){
               eliminarIesimo(i);
               a++;
           }   
       }  
       
       public void eliminarDuplicados() {
    if (vacio())return;
    Nodo p = this.prim;
    int c=1;
    while (p != null) {
        if (this.frecuencia(p.elem)>1){
           eliminarIesimo(c); 
           c=0;
           p=this.prim;
        } else { 
        c++;
        p = p.prox;}  
    }
}
       public void eliminar(Lista L2){
          if (L2.vacio()) return;
           Nodo p=L2.prim;
         while (p != null){
             eliminarTodo(p.elem);
             p=p.prox;
         }
       }
       public void eliminarDesde(int i,int n){
       if (vacio()) return; 
    int c=1;
    while (c<=n && i<=cantElem) {
        this.eliminarIesimo(i);
        c++; 
    }
       }
       public void eliminarUnicos(){
          Nodo p=this.prim;
          while (p != null){
              if (frecuencia(p.elem)==1){
              eliminarTodo(p.elem);
              p=this.prim;
              } else
              p=p.prox;
          }
       }
    //Laboratorio - 7
       public void insertarIesimo(Lista L2,int i){
        if (L2.vacio())return;
        Nodo p=L2.prim;
        while(p != null){
            this.insertarIesimo(p.elem,i);
            p=p.prox;
        }
       }
       
       public void insertarPrim(Lista L2){
           if (L2.vacio())return;
           Nodo p=L2.prim;
           while(p != null ){
               this.insertarPrim(p.elem);
               p=p.prox;
           }       
       }
       
       public void insertarUltI(Lista L2){
         if (L2.vacio())return;
           Nodo p=L2.prim;
           while(p != null ){
               this.insertarUlt(p.elem);
               p=p.prox;
           }      
       }
       public void insertarAsc(int x){
           this.insertarLugarAsc(x);
       }
       public void insertarDesc(int x){
           this.insertarLugarDesc(x);
       }
       public void concatenar(Lista L2,Lista L3){
           this.insertarPrim(L2);
           this.insertarUltI(L3);
       }
      public void intercalarI(Lista L2,Lista L3){
          L2.intercalar(L3,this);
      }
      public void merge(Lista L2,Lista L3){
          L2.intercalar(L3,this);
          this.OrdenarAsc();
      }
      public int indexOf(int x){
         Nodo p=this.prim;
         int pos=1;
         while (p != null){
             if (p.elem==x)
                 return pos;
             pos++;
             p=p.prox;
         }
         return -1;
      }
      public int indexOf(int x,int i){
          Nodo p=Direccion(i);
         int pos=i;
         while (p != null){
             if (p.elem==x)
                 return pos;
             pos++;
             p=p.prox;
         }
         return -1;
      }
      public void reemplazarI(int x,int y){
          if (vacio())return;
          Nodo p=this.prim;
          while(p != null){
              this.reemplazar(x,y);
              p=p.prox;
          }
      }
      public void invertir(){
          if (vacio())return;
          Nodo p=this.prim;
          for(int i=1; i<=cantElem/2;i++){
              int aux=p.elem;
              Nodo p2=Direccion(this.cantElem-i+1);
              p.elem=p2.elem;
              p2.elem=aux;
              p=p.prox;
          } 
      }
      //Eliminar elementos de una lista
      public void eliminarUltI(int x){
          if (vacio())return;
          int i =cantElem;
          while(i>0){
              Nodo p=Direccion(i);
              if (p.elem==x){
                  this.eliminarIesimo(i);
                  return;
              }
             i--;
          }
      }
     public void eliminarExtremos(int n){
         int i=1;
         while(i<=n){
             this.eliminarPrim();
             this.eliminarUlt();
             i++;
         }
     }
     public void eliminarPares(){
         if (vacio())return;
         Nodo p=this.prim;
        while (p != null){
            if (espar(p.elem)){
                this.eliminarTodo(p.elem);
             p=this.prim;   
            }else
            p=p.prox;
        }
     } 
     public void eliminarImpares(){
         if (vacio())return;
         Nodo p=this.prim;
        while (p != null){
            if (!espar(p.elem)){
                this.eliminarTodo(p.elem);
             p=this.prim;   
            }else
            p=p.prox;
        }
     } 
     
    public void eliminarTodos(Lista L2){
        if (vacio())return;
        Nodo p=L2.prim;
        while (p != null){
            this.eliminarTodo(p.elem);
            p=p.prox;
        } 
    }
    
    public void eliminarVeces(int k){
        if (vacio())return;
        Nodo p=this.prim;
        while ( p != null){
            if (this.frecuencia(p.elem)== k){
                this.eliminarTodo(p.elem);
                p=this.prim;
            }else p=p.prox;
        }
    }
      public void eliminarAlternos(){
     if (vacio()) return;

    Nodo p = this.prim; 
    int c=1; 
    
    while (p != null && p.prox != null) {
        this.eliminarIesimo(c+1); 
        p = p.prox; 
        c++;
         }   
      }
     
      
} //end.
