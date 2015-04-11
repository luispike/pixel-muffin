/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.dao;

import java.util.List;
import mx.unam.ciencias.model.Local;

/**
 *
 * @author guillermorojas
 */
public interface LocalRepository {
    
    void save(Local local);/******/
    
    void delete(Local local);/******/
    
    void delete(Iterable<Local> locales);/******/
    
    List<Local> findAll();

    Local findOne(Integer id);/******/
    
    boolean exists(Integer id);/******/
    
    List<Local> findByNombre(String nombre);
    
    List<Local> findByCategoria(String categoria);
    
    List<Local> findByNombreMenu(String menu);
    
}
