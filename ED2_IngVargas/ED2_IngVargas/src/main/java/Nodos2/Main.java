/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Nodos2;

public class Main {
    public static void main(String[] args) {

Lista3 L1=new Lista3(3);

L1.elem[0].insertarUlt("hola");
L1.elem[0].insertarUlt("comos");
L1.elem[0].insertarUlt("estas tu");

L1.elem[1].insertarUlt("pedro clavo un");
L1.elem[1].insertarUlt(" buenos dias");
L1.elem[1].insertarUlt("buenas tardes no");

L1.elem[2].insertarUlt("buenos dias Barcelona");
L1.elem[2].insertarUlt(" buenos dias real madrid");
L1.elem[2].insertarUlt("Buenos Dias Familia del barr");




L1.mayAMenor();
System.out.println("");
L1.menAMayor();


//       Lista2 p= new Lista2();
//       p.insertarPrim(2);
//       p.insertarPrim(4);
//       p.insertarPrim(6);
//       p.insertarPrim(8);
//       p.insertarPrim(9);
//       p.insertarPrim(10);
      
       
   
//   p.ordenarAsc();     
//   System.out.println(p);
    

    }// end.main
}//end.class
