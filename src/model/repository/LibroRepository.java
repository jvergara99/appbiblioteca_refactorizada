package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.entity.Libro;

/**
 * Repositorio para gestionar libros en el sistema.
 * Implementa el patrón Singleton.
 */
public class LibroRepository implements Repository<Libro, Integer> {
    private static LibroRepository instance; 
    private final List<Libro> libros; 

    /** 
     * Constructor privado para evitar instanciación directa. 
     */ 
    private LibroRepository() { 
        this.libros = new ArrayList<>(); 
    } 

    /** 
     * Obtiene la instancia única del repositorio. 
     * @return Instancia del repositorio de libros 
     */ 
    public static synchronized LibroRepository getInstance() { 
        if (instance == null) { 
            instance = new LibroRepository(); 
        } 
        return instance; 
    } 

    @Override 
    public Libro save(Libro libro) { 
        // Verificar si ya existe un libro con el mismo ID 
        if (findById(libro.getId()).isPresent()) { 
            throw new IllegalArgumentException("Ya existe un libro con el ID " + libro.getId()); 
        } 
        libros.add(libro); 
        return libro; 
    } 

    @Override 
    public Optional<Libro> findById(Integer id) { 
        return libros.stream() 
                .filter(libro -> libro.getId() == id) 
                .findFirst(); 
    } 

    @Override 
    public List<Libro> findAll() { 
        return new ArrayList<>(libros); 
    } 

    @Override 
    public void delete(Libro libro) { 
        libros.remove(libro); 
    } 

    @Override 
    public Libro update(Libro libro) { 
        Optional<Libro> existente = findById(libro.getId()); 
        if (!existente.isPresent()) { 
            throw new IllegalArgumentException("No existe un libro con el ID " + libro.getId()); 
        }  
        // Eliminar el libro existente y añadir el actualizado 
        delete(existente.get()); 
        libros.add(libro); 
        return libro; 
    } 

    /** 
     * Busca libros por título, autor o género. 
     * @param campo Campo de búsqueda (\"titulo\", \"autor\", \"genero\") 
     * @param valor Valor a buscar 
     * @return Lista de libros que coinciden con el criterio 
     */ 
    public List<Libro> buscarPor(String campo, String valor) { 
        String valorLower = valor.toLowerCase(); 
        switch (campo.toLowerCase()) { 
            case "titulo": 
                return libros.stream() 
                        .filter(libro -> libro.getTitulo().toLowerCase().contains(valorLower)) 
                        .collect(Collectors.toList()); 
            case "autor": 
                return libros.stream() 
                        .filter(libro -> libro.getAutor().toLowerCase().contains(valorLower)) 
                        .collect(Collectors.toList()); 
            case "genero": 
                return libros.stream() 
                        .filter(libro -> libro.getGenero().toLowerCase().contains(valorLower)) 
                        .collect(Collectors.toList()); 
            default: 
                throw new IllegalArgumentException("Campo de búsqueda no válido: " + campo); 
        } 
    } 

    /** 
     * Obtiene una lista de libros disponibles para préstamo. 
     * @return Lista de libros disponibles 
     */ 
    public List<Libro> findDisponibles() { 
        return libros.stream() 
                .filter(Libro::isDisponible) 
                .collect(Collectors.toList()); 
    } 

}
