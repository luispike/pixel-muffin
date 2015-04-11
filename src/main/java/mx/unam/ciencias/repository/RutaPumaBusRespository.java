/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.repository;

import java.io.Serializable;
import java.util.List;
import mx.unam.ciencias.model.RutaPumaBus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author guillermorojas
 */
public interface RutaPumaBusRespository extends CrudRepository<RutaPumaBus, Integer>{
    
    @Query("SELECT r FROM RutaPumaBus r")
    @Override
    List<RutaPumaBus> findAll();
}
