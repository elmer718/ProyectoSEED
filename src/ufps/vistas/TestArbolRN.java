/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.vistas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ufps.modelo.Libro;
import ufps.util.colecciones_seed.ArbolBinarioBusqueda;
import ufps.util.colecciones_seed.ArbolRojiNegro;

/**
 *
 * @author FARO
 */
public class TestArbolRN {
    
    public static void main(String[] args) {

        ArbolBinarioBusqueda<Libro> arbolBST = new ArbolBinarioBusqueda<>();
        ArbolRojiNegro<Libro> arbolRN = new ArbolRojiNegro<>();
        
        // Creamos los ID's
        List<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            ids.add(i);
        }
        
        // Mezclamos los datos para simular inserciones desordenadas
        Collections.shuffle(ids);
        
        // INSERTAR ArbolBST
        long inicio = System.nanoTime();
        for (int id : ids) {
            Libro libro = new Libro(id, "Libro " + id, "");
            arbolBST.insertar(libro);
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo de inserción en árbol BST: " + (fin - inicio) + " ns");
        
        // INSERTAR ArbolRN
        inicio = System.nanoTime();
        for (int id : ids) {
            Libro libro = new Libro(id, "Libro " + id, "");
            arbolRN.insertar(libro);
        }
        fin = System.nanoTime();
        System.out.println("Tiempo de inserción en árbol RojiNegro: " + (fin - inicio) + " ns");
        
        // BUSCAR
        inicio = System.nanoTime();
        boolean encontrado = arbolRN.esta(new Libro(50, "", ""));
        fin = System.nanoTime();
        System.out.println("Tiempo de búsqueda: " + (fin - inicio) + " ns, encontrado: " + encontrado);

        // ELIMINAR
        inicio = System.nanoTime();
        arbolRN.eliminar(new Libro(30, "", ""));
        fin = System.nanoTime();
        System.out.println("Tiempo de eliminación: " + (fin - inicio) + " ns");

        // IMPRIMIR
        System.out.println("\nImpresión del árbol Rojo-Negro:");
        arbolRN.imprime();
    }
}
