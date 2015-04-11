/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.service;

import java.util.List;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.model.RutaPumaBus;

/**
 *
 * @author guillermorojas
 */
public interface LocalService {
    
    void guardaLocal(Local local);
    
    void eliminarLocal(Local local);
    
    List<Local> findAll();
    
    List<Local> findByNombre(String nombre);
    
    List<Local> findByCategoria(String categoria);
    
    List<Local> findByMenu(String nombreMenu);
    
    List<RutaPumaBus> findAllRutas();
    
    List<Local> findByRutas(String nombreRuta);
    
    List<Local> findByPrecios(Double inferior,Double superior);
    
    List<Local> findByPunto(Double lat,Double lon);
    
}
