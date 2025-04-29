package model.entity;

public class LibroFisico extends Libro {
    
    private String ubicacion; 
    private int numeroPaginas; 

    /** 
     * Constructor para crear un nuevo libro físico. 
     * @param id Identificador único del libro 
     * @param titulo Título del libro 
     * @param autor Autor del libro 
     * @param anioPublicacion Año de publicación 
     * @param genero Género literario 
     * @param ubicacion Ubicación física en la biblioteca 
     * @param numeroPaginas Número de páginas 
     */ 

    public LibroFisico(int id, String titulo, String autor, int anioPublicacion,  
                      String genero, String ubicacion, int numeroPaginas) { 
        super(id, titulo, autor, anioPublicacion, genero); 
        this.ubicacion = ubicacion; 
        this.numeroPaginas = numeroPaginas; 
    } 

    public String getUbicacion() { 
        return ubicacion; 
    } 

    public void setUbicacion(String ubicacion) { 
        this.ubicacion = ubicacion; 
    } 

    public int getNumeroPaginas() { 
        return numeroPaginas; 
    } 

    public void setNumeroPaginas(int numeroPaginas) { 
        if (numeroPaginas <= 0) { 
            throw new IllegalArgumentException("El número de páginas debe ser positivo"); 
        } 
        this.numeroPaginas = numeroPaginas; 
    } 

    @Override 
    public String getTipoLibro() { 
        return "Físico"; 
    } 

}