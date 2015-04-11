/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guillermorojas
 */
@Entity
@Table(name="RUTA_PUMA_BUS")
public class RutaPumaBus implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_RUTA_PUMA_BUS")
    private Integer id;
    
    @NotNull
    @Column(name="NOMBRE_RUTA")
    private String nombreRuta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    
}
