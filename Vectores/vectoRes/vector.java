/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gus.vectores;
 import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Vector {
    private int elem[];
    private  int max;
    private int  cantelem;
     
    public void crear(){
        this.max=1200;
        this.cantelem=0;
        this.elem=new int[max];
    }
     public void cargar_ramdon(int ele){
         this.cantelem=ele;
         Random num_random=new Random();
    
         for (int i=0;i<cantelem;i++){
         elem[i]=num_random.nextInt(100);
         }
     }
     public void ordenar_asc(){
         for(int i=0;i<this.cantelem;i++){
             int c=i;
             for (int j=i+1;j<this.cantelem;j++){
                 if (elem[j]<=elem[c])
                     c=j;
             }
             int aux=elem[i];
             elem[i]=elem[c];
             elem[c]=aux;
         }
     }
     @Override
     public  String toString(){
         if (this.cantelem==0){
             return "[]";
         } else{
             String aux="[";
         for (int i=0;i<this.cantelem;i++){
         aux=aux+this.elem[i]+",";  
         }
         return aux+"]";}
     }
     
    public void Insertarlesimo(int x,int i){
        if (this.cantelem !=0 && (-1<i && i<this.cantelem )){
            int k=this.cantelem;
            this.cantelem++;
         while(i<=k){
          elem[k]=elem[k-1];
          k--;
         }
         elem[i]=x;
        } else{
           JOptionPane.showMessageDialog(null, "Fuera de Rango");  
        }
    }    
    public void InsertarPrim (int x){
        
    }
}
