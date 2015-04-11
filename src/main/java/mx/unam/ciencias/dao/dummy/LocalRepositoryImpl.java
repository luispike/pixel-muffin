/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.dao.dummy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.unam.ciencias.dao.LocalRepository;
import mx.unam.ciencias.model.Local;
import mx.unam.ciencias.model.Menu;
import mx.unam.ciencias.utils.GuardaObjectoFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillermorojas
 */
public class LocalRepositoryImpl implements LocalRepository,Serializable{
    
    private static final String FILE_NAME="/Users/guillermorojas/Desktop/locales.serialized";
  //  private static final String FILE_NAME="locales.serialized";
    
    private List<Local> locales;
    
 
    
    public LocalRepositoryImpl(){
        if(GuardaObjectoFile.recuperaObjecto(FILE_NAME)==null){
            locales=new ArrayList<>();
        }
        else{
            locales=(List<Local>) GuardaObjectoFile.recuperaObjecto(FILE_NAME);
        }
    }
    

    
    @Override
    public void save(Local local) {
        if(!locales.contains(local)){
            locales.add(local);
        }
        GuardaObjectoFile.guardarEnArchivo(locales, FILE_NAME);
    }

    @Override
    public void delete(Local local) {
        if(this.locales.contains(local)){
            this.locales.remove(local);
            GuardaObjectoFile.guardarEnArchivo(locales, FILE_NAME);
        }
    }

    @Override
    public void delete(Iterable<Local> locales) {
        for(Local local:locales){
            if(this.locales.contains(local)){
                this.locales.remove(local);
                GuardaObjectoFile.guardarEnArchivo(locales, FILE_NAME);
            }
        }
    }

    @Override
    public List<Local> findAll() {
        return this.locales;
    }

    @Override
    public Local findOne(Integer id) {
        Local localBusqueda=null;
        for(Local local:locales){
            if(local.getId().equals(id)){
                localBusqueda=local;
                break;
            }
        }
        return localBusqueda;
    }

    @Override
    public boolean exists(Integer id) {
        boolean exist=false;
        for(Local local:locales){
            if(local.getId().equals(id)){
                exist=true;
                break;
            }
        }
        return exist;
    }

    @Override
    public List<Local> findByNombre(String nombre) {
        List<Local> localesBusqueda=new ArrayList<>();
        for(Local local:locales){
            if(local.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                localesBusqueda.add(local);
            }
        }
        return localesBusqueda;
    }

    @Override
    public List<Local> findByCategoria(String categoria) {
        List<Local> localesBusqueda=new ArrayList<>();
        for(Local local:locales){
            if(local.getMenu()!=null){
                for(Menu menu:local.getMenu()){
                    if(menu.getCategoria().toLowerCase().contains(categoria.toLowerCase())){
                        localesBusqueda.add(local);
                        break;
                    }
                }
            }
        }
        return localesBusqueda;
    }

    @Override
    public List<Local> findByNombreMenu(String menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}