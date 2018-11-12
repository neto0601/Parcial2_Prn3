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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Marca;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.ModeloParte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Parte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoParte;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoVehiculo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.MarcaFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ModeloFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ModeloParteFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.ParteFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.TipoParteFacade;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.TipoVehiculoFacade;

/**
 *
 * @author neto
 */
@Named
@ViewScoped
public class FrmModeloParte implements Serializable {

    @Inject
    private ModeloFacade modeloFacade;
    @Inject
    private ParteFacade parteFacade;
    @Inject
    private TipoParteFacade tipoParteFacade;
    @Inject
    private ModeloParteFacade modeloParteFacade;
    @Inject 
    TipoVehiculoFacade tipoVehiculoFacade;
    @Inject
    MarcaFacade marcaFacade;        

    Modelo modelo;
    Modelo modelo2;
    TipoVehiculo tipoVehiculo;
    Marca marca;
    Parte parte;
    TipoParte tipoParte;
    ModeloParte modeloParte;

    List<ModeloParte> listaModeloParte;

    List<Modelo> listaModelo;

    private boolean value1;
    
    

    public FrmModeloParte() {

    }

    public FrmModeloParte(ModeloParteFacade modeloParteFacade, ModeloFacade modeloFacade, ParteFacade parteFacade, Modelo registro) {
        this.modelo = new Modelo();
        this.modelo = registro;
        tipoVehiculo = new TipoVehiculo();
        marca = new Marca();

        /*listaPartes = new ArrayList();
        try {
            listaPartes = parteFacade.findAll();
        } catch (Exception ex) {
            this.listaPartes = Collections.EMPTY_LIST;
        }*/
    }

    @PostConstruct
    public void inicializar() {
        modelo = new Modelo();
        tipoVehiculo = new TipoVehiculo();
        marca = new Marca();
        modelo2 = new Modelo();
        this.crearTablaModelo();
        this.crearTablaModeloParte();
    }
    
    public void guardar(){
        if (modelo != null) {
            modelo.setIdTipoVehiculo(tipoVehiculoFacade.find(tipoVehiculo.getIdTipoVehiculo()));
            modelo.setIdMarca(marcaFacade.find(marca.getIdMarca()));
            modeloFacade.create(modelo);
            this.crearTablaModelo();
        } else {
            throw new IllegalStateException();
        }  
    }
    
    public void seleccionarRegistro(SelectEvent event){       
        modelo2 = (Modelo)event.getObject();
        actualizar();
        
    }
    
    public void actualizar(){
        if(modelo2 != null){
            setModelo(modelo2);
        }
        
    }
    
    public void resetFail(){
        modelo.setNombre(null);
        modelo.setAnio(null);
        
    }

    public List<Modelo> crearTablaModelo() {
        listaModelo = new ArrayList();
        try {
            listaModelo = modeloFacade.findAll();
        } catch (Exception ex) {
            this.listaModelo = Collections.EMPTY_LIST;
        }
        return this.listaModelo;
    }

    public List<ModeloParte> crearTablaModeloParte() {
        listaModeloParte = new ArrayList();
        try {
            listaModeloParte = modeloParteFacade.findAll();
        } catch (Exception ex) {
            this.listaModeloParte = Collections.EMPTY_LIST;
        }
        return this.listaModeloParte;
    }

    public List<ModeloParte> getListaModeloParte() {
        return listaModeloParte;
    }

    public void setListaModeloParte(List<ModeloParte> listaModeloParte) {
        this.listaModeloParte = listaModeloParte;
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
    
    public boolean isValue1() {
        return value1;
    }

//<p:ajax event="tabChange" listener="#{frmModelo.tabChangeHandler}"/>
    //</h:form> 39
    //</ui:define> 40
    //<ui:define name="content"> 42
    //<h:form id="form2"> 43
}
