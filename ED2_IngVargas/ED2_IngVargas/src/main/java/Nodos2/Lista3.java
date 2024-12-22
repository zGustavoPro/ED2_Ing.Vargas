/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos2;

/**
 *
 * @author usuario
 */
public class Lista3 {  //Lista
public Lista2 elem[];
public int cantelem;
public int max;


public Lista3 (int max){
this.max=max;
this.cantelem=max;
this.elem=new Lista2[max];
for (int i = 0; i < this.max; i++) {
elem[i]=new Lista2();        
    }
}   

public void mayAMenor(){
  for (int i = 0; i <this.max; i++) {
        elem[i].ordenarDesc();
    }
    
    for (int i = 0; i <this.max; i++) {
     System.out.println("Lista " + (i+1) + ": " + elem[i].toString());
    }  
}
public void menAMayor(){
   for (int i = 0; i <this.max; i++) {
        elem[i].ordenarAsc();
    }
    
    for (int i = 0; i <this.max; i++) {
        System.out.println("Lista " + (i+1) + ": " + elem[i].toString());
    } 
}




}//end.

