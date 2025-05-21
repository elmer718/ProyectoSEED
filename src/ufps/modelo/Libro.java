/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufps.modelo;

/**
 *
 * @author FARO
 */
public class Libro implements Comparable<Libro>{
    private int id;
    private String titulo;
    private String autor;

    public Libro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    @Override
    public int compareTo(Libro o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return String.valueOf(id); // importante para el árbol y método imprimeRN
    }
}
