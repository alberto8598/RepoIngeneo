package co.com.s.usecase.unitmeasure;

import java.util.List;
import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.unitmeasure.Logistica;
import co.com.s.model.unitmeasure.gateways.IComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UseCase {

    private final IComponent iLogisticaComponent;

    /** Método encargado de guardar o actualizar logistica
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public Logistica save(Logistica logistica) throws GeneralServiceException {
        return iLogisticaComponent.save(logistica);
    }

    /** Método encargado de listar logistica
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    public List<Logistica> findAll() throws  GeneralServiceException {
        return iLogisticaComponent.findAll();
    }

    public Logistica findById(String id) throws  GeneralServiceException {
        return iLogisticaComponent.findById(id);
    }
    public void deleteById(String id) {
        iLogisticaComponent.deleteById(id);
    }

}
