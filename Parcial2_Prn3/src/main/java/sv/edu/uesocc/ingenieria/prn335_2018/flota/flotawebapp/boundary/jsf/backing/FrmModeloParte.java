/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.boundary.jsf.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Marca;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Parte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoParte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ModeloFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ModeloParteFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ParteFacade;


/**
 *
 * @author neto
 */

@Named
@ViewScoped
public class FrmModeloParte implements Serializable{

    @Inject
    private ModeloFacade modeloFacade;
    @Inject
    private ParteFacade parteFacade;        

    Modelo modelo;
    TipoVehiculo tipoVehiculo;
    Marca marca;
    Parte parte;
    TipoParte tipoParte;
    
    
    List<Parte> listaPartes;
    
    List<Modelo> listaModelo;
       
    public FrmModeloParte(){
        
    }
       
    public FrmModeloParte(ModeloParteFacade modeloParteFacade, ModeloFacade modeloFacade, ParteFacade parteFacade, Modelo registro) {
        this.modelo = new Modelo();
        this.modelo=registro;
        tipoVehiculo = new TipoVehiculo();
        marca = new Marca();
        
        
        listaPartes = new ArrayList();      
        try {
           listaPartes = parteFacade.findAll(); 
        } catch (Exception ex) {
            this.listaPartes = Collections.EMPTY_LIST;
        }
    }
    
    @PostConstruct
    public void inicializar(){
        modelo = new Modelo();
        tipoVehiculo = new TipoVehiculo();
        marca = new Marca();
        this.crearTablaModelo();
        this.crearTablaParte();
    }
    
    public List<Modelo> crearTablaModelo(){
        listaModelo = new ArrayList();      
        try {
           listaModelo = modeloFacade.findAll(); 
        } catch (Exception ex) {
            this.listaModelo = Collections.EMPTY_LIST;
        } return this.listaModelo;
    }
    
    public List<Parte> crearTablaParte(){
        listaPartes = new ArrayList();      
        try {
           listaPartes = parteFacade.findAll(); 
        } catch (Exception ex) {
            this.listaPartes = Collections.EMPTY_LIST;
        } return this.listaPartes;
    }

    public List<Parte> getListaPartes() {
        return listaPartes;
    }

    public void setListaPartes(List<Parte> listaPartes) {
        this.listaPartes = listaPartes;
    }

    public List<Modelo> getListaModelo() {
        return listaModelo;
    }

    public void setListaModelo(List<Modelo> listaModelo) {
        this.listaModelo = listaModelo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
//<p:ajax event="tabChange" listener="#{frmModelo.tabChangeHandler}"/>
                                    
    
}
