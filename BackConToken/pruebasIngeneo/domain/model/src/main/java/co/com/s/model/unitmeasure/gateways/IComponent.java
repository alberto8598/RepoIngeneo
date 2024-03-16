package co.com.s.model.unitmeasure.gateways;

import java.util.List;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.unitmeasure.Logistica;

public interface IComponent {

    /** Método encargado de guardar o actualizar las unidades de medida
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */

    Logistica save(Logistica unitMeasure) throws GeneralServiceException;

    /** Método encargado de listar logistica
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    List<Logistica> findAll() throws GeneralServiceException;
    Logistica findById(String id) throws GeneralServiceException;

    void deleteById(String id) throws GeneralServiceException;
}
