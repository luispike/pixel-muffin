/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
/**
 *
 * @author guillermorojas
 */


@Controller("saludoController")
@Scope("session")
public class SaludoController {

    
    private Date fecha=new Date();
    
    private String saludo;

    private String nombre;
    
    private List<String> nombres;
    
    
    
    @PostConstruct
    public void init(){
        nombres=new ArrayList<>();
        nombre="Default";
        saludo="Hola Mundo!";
    }
    
    public void cambiaNombre(){
        nombres.add(nombre);
        if(!this.nombre.isEmpty()){
            this.nombre+=" Rojas";
        }
    }
    
    
    public String getSaludoMundial() {
        return saludo;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getNombres() {
        return nombres;
    }


    
    
    
    
    
}
