package model.entity;

import java.util.Objects;

public abstract class Libro {
    private int id; 
    private String titulo; 
    private String autor; 
    private int anioPublicacion; 
    private String genero; 
    private boolean disponible; 

    /** 
     * Constructor para crear un nuevo libro. 
     * @param id Identificador único del libro 
     * @param titulo Título del libro 
     * @param autor Autor del libro 
     * @param anioPublicacion Año de publicación 
     * @param genero Género literario 
     */ 
    public Libro(int id, String titulo, String autor, int anioPublicacion, String genero) { 
        this.id = id; 
        this.titulo = titulo; 
        this.autor = autor; 
        this.anioPublicacion = anioPublicacion; 
        this.genero = genero; 
        this.disponible = true; 
    } 

    public int getId() { 
        return id; 
    } 

    public void setId(int id) { 
        if (id <= 0) { 
            throw new IllegalArgumentException("El ID debe ser un número positivo"); 
        } 
        this.id = id; 
    } 

    public String getTitulo() { 
        return titulo; 
    } 

    public void setTitulo(String titulo) { 
        if (titulo == null || titulo.trim().isEmpty()) { 
            throw new IllegalArgumentException("El título no puede estar vacío"); 
        } 
        this.titulo = titulo; 
    } 

    public String getAutor() { 
        return autor; 
    } 

    public void setAutor(String autor) { 
        if (autor == null || autor.trim().isEmpty()) { 
            throw new IllegalArgumentException("El autor no puede estar vacío"); 
        } 
        this.autor = autor; 
    } 

    public int getAnioPublicacion() { 
        return anioPublicacion; 
    } 

    public void setAnioPublicacion(int anioPublicacion) { 
        if (anioPublicacion <= 0) { 
            throw new IllegalArgumentException("El año de publicación debe ser positivo"); 
        } 
        this.anioPublicacion = anioPublicacion; 
    } 

    public String getGenero() { 
        return genero; 
    } 

    public void setGenero(String genero) { 
        this.genero = genero; 
    } 
   
    public boolean isDisponible() { 
        return disponible; 
    } 

    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    } 

    /** 
     * Método abstracto que deben implementar las subclases para describir 
     * el tipo específico de libro. 
     * @return Descripción del tipo de libro 
     */ 
    public abstract String getTipoLibro(); 
    
    /** 
     * Proporciona una representación de cadena del libro. 
     * @return Cadena con información del libro 
     */ 
    @Override 
    public String toString() { 
        return String.format("ID: %d | Título: %s | Autor: %s | Año: %d | Género: %s | Tipo: %s | Disponible: %s", 
                id, titulo, autor, anioPublicacion, genero, getTipoLibro(), disponible ? "Sí" : "No"); 
    } 

    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Libro libro = (Libro) o; 
        return id == libro.id; 
    } 

    @Override 
    public int hashCode() { 
        return Objects.hash(id); 
    } 

}
