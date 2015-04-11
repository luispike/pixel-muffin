/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author guillermorojas
 */
@Entity
@Table(name = "LOCAL")
public class Local implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Column(name = "NOMBRE")
    private String nombre;
    
    @NotNull
    @Column(name = "LATITUD")
    private Double latitud;
    
    @NotNull
    @Column(name = "LONGITUD")
    private Double longitud;
     
    @NotNull
    @Column(name = "RANGO_INFERIOR")
    private Double rangoInferior;
     
    @NotNull
    @Column(name = "RANGO_SUPERIOR")
    private Double rangoSuperior;
     
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Menu recomendacion;
     
    
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "local",
            orphanRemoval = true)
    private List<Menu> menu;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RutaPumaBus> rutas;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Menu getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(Menu recomendacion) {
        this.recomendacion = recomendacion;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public Double getRangoInferior() {
        return rangoInferior;
    }

    public void setRangoInferior(Double rangoInferior) {
        this.rangoInferior = rangoInferior;
    }

    public Double getRangoSuperior() {
        return rangoSuperior;
    }

    public void setRangoSuperior(Double rangoSuperior) {
        this.rangoSuperior = rangoSuperior;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.latitud);
        hash = 17 * hash + Objects.hashCode(this.longitud);
        hash = 17 * hash + Objects.hashCode(this.rangoInferior);
        hash = 17 * hash + Objects.hashCode(this.rangoSuperior);
        return hash;
    }

    public List<RutaPumaBus> getRutas() {
        return rutas;
    }

    public void setRutas(List<RutaPumaBus> rutas) {
        this.rutas = rutas;
    }

  

    
     
}
