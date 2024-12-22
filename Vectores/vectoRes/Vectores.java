/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gus.vectores;
import com.gus.vectores.vector;
public class Vectores {

    public static void main(String[] args) {
         vector p=new vector();
         p.crear();
         p.cargar_ramdon(10);
       System.out.println(p.toString());
       
    }
}
