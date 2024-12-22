/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author usuario
 */
public class ListasArboles {
private Arbol[] arboles;
private int max;

   public ListasArboles(int max) {
       this.max=max;
        arboles = new Arbol[max];
        for (int i = 0; i < arboles.length; i++) {
            arboles[i] = new Arbol();
        }
    }

    public void insertar(int num) {
        int ultimoDigito = num % 10;
        arboles[ultimoDigito].insertar(num);
    }

    public void mostrarElementos() {
        for (int i = 0; i < arboles.length; i++) {
            ArrayList<Integer> lista = new ArrayList<>();
            arboles[i].inOrden(lista);
            if (!lista.isEmpty()) {
                System.out.println("Elementos con último dígito " + i + ": " + lista);
            }
        }
    }

    public void consultas(int digito) {
        ArrayList<Integer> lista = new ArrayList<>();
        arboles[digito].inOrden(lista);
        if (lista.isEmpty()) {
            System.out.println("No hay elementos con último dígito " + digito);
            return;
        }

        // Ejemplo de consultas
        System.out.println("Consultas sobre el árbol con último dígito " + digito + ":");
        System.out.println("Cantidad de elementos: " + lista.size());
        System.out.println("Suma de elementos: " + lista.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Mayor elemento: " + lista.get(lista.size() - 1));
        System.out.println("Menor elemento: " + lista.get(0));
        System.out.println("Elementos: " + lista);
    }
}

