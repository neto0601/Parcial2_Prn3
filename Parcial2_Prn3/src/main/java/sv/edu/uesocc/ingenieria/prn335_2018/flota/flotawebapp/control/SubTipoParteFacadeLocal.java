/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.SubTipoParte;

/**
 *
 * @author neto
 */
@Local
public interface SubTipoParteFacadeLocal {

    void create(SubTipoParte subTipoParte);

    void edit(SubTipoParte subTipoParte);

    void remove(SubTipoParte subTipoParte);

    SubTipoParte find(Object id);

    List<SubTipoParte> findAll();

    List<SubTipoParte> findRange(int[] range);

    int count();
    
}
