package model.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz genérica que define operaciones básicas de repositorio.
 * @param <T>  Tipo de entidad
 * @param <ID> Tipo del identificador
 */
public interface Repository<T,ID> {
    /** 
     * Guarda una entidad en el repositorio. 
     * @param entity Entidad a guardar 
     * @return La entidad guardada 
     */ 
    T save(T entity); 

    /** 
     * Busca una entidad por su ID. 
     * @param id Identificador de la entidad 
     * @return Un Optional que puede contener la entidad si se encuentra 
     */ 
    Optional<T> findById(ID id); 

    /** 
     * Recupera todas las entidades del repositorio. 
     * @return Lista de todas las entidades 
     */ 
    List<T> findAll(); 

    /** 
     * Elimina una entidad del repositorio. 
     * @param entity Entidad a eliminar 
     */ 
    void delete(T entity); 

    /** 
     * Actualiza una entidad existente. 
     * @param entity Entidad con valores actualizados 
     * @return La entidad actualizada 
     */ 
    T update(T entity); 

}
