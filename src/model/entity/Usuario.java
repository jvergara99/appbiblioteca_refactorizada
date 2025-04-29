package model.entity;

import java.util.Objects;

public abstract class Usuario {
    private int id; 
    private String nombre; 
    private String email; 
    private String telefono; 

    /** 
     * Constructor para un nuevo usuario. 
     * @param id Identificador único del usuario 
     * @param nombre Nombre completo del usuario 
     * @param email Correo electrónico del usuario 
     * @param telefono Número de teléfono del usuario 
     */ 
    public Usuario(int id, String nombre, String email, String telefono) { 
        this.id = id; 
        this.nombre = nombre; 
        this.email = email; 
        this.telefono = telefono; 
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
   
    public String getNombre() { 
        return nombre; 
    } 

    public void setNombre(String nombre) { 
        if (nombre == null || nombre.trim().isEmpty()) { 
            throw new IllegalArgumentException("El nombre no puede estar vacío"); 
        } 
        this.nombre = nombre; 
    } 

    public String getEmail() { 
        return email; 
    } 

    public void setEmail(String email) { 
        if (email == null || !email.contains("@")) { 
            throw new IllegalArgumentException("El email debe ser válido"); 
        } 
        this.email = email; 
    } 
    
    public String getTelefono() { 
        return telefono; 
    } 

    public void setTelefono(String telefono) { 
        this.telefono = telefono; 
    } 

    /** 
     * Obtiene el límite de libros que este tipo de usuario puede tomar prestados. 
     * @return Número máximo de libros que puede tomar prestados 
     */ 
    public abstract int getLimiteLibros(); 
     
    /** 
     * Obtiene el tipo de usuario para fines de visualización. 
     * @return Cadena que representa el tipo de usuario 
     */ 
    public abstract String getTipoUsuario(); 

    /** 
     * Proporciona una representación de cadena del usuario. 
     * @return Cadena con información del usuario 
     */ 
    @Override 
    public String toString() { 
        return String.format("ID: %d | Nombre: %s | Tipo: %s | Email: %s | Teléfono: %s | Límite: %d libros", 
                id, nombre, getTipoUsuario(), email, telefono, getLimiteLibros()); 
    } 

    @Override 
    public boolean equals(Object o) { 
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false; 
        Usuario usuario = (Usuario) o; 
        return id == usuario.id; 
    } 
     
    @Override 
    public int hashCode() { 
        return Objects.hash(id); 
    } 

}
