/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.boundary.jsf;

import java.util.List;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.AbstractFacade;


/**
 *
 * @author neto
 */
public abstract class AbstractFrmDataModel<T> {
    
    protected Modelo registro;       
    
    protected List<T> lista;
    
    protected boolean Visible = false;
    
    protected LazyDataModel<T> lazyModel;
    
    public void inicializar(){
        registro = new Modelo();
    }
    
    public abstract Object clavePorDatos(T object);
    
    //public abstract T datosPorClave(String rowkey);
    
    public void crearNuevo(){
        this.Visible = true;
    }
    
    public void btnEliminarHandler(ActionEvent ae){
        if(registro != null && getFacade() != null){
            getFacade().remove(registro);
        }
    }
    
    public void btnCancelarHandler(ActionEvent ae){
        this.Visible = false;
    }
    
    public LazyDataModel<T> getModelo(){
      return lazyModel;
    }
    
    public abstract AbstractFacade getFacade();
    
   
}
