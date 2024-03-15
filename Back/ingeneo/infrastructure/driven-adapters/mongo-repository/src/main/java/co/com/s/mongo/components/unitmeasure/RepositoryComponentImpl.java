package co.com.s.mongo.components.unitmeasure;

import co.com.s.model.exceptions.GeneralServiceException;
import co.com.s.model.exceptions.ValidateServiceException;
import co.com.s.model.unitmeasure.Logistica;
import co.com.s.model.unitmeasure.gateways.IComponent;
import co.com.s.mongo.mapper.unitmeasure.ILogisticaMapper;
import co.com.s.mongo.repository.unitmeasure.ILogisticaRepository;
import co.com.s.mongo.services.FieldsValidationService;
import co.com.s.mongo.services.ServiceUtilities;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class RepositoryComponentImpl implements IComponent {
    private final ILogisticaRepository iLogisticaRepository;
    private final ILogisticaMapper iLogisticaMapper;
    private final FieldsValidationService fieldsValidationService;
    private final ServiceUtilities serviceUtilities;

    /** Método encargado de guardar o actualizar las logistica
     * @return objeto Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    @Override
    public Logistica save(Logistica logistica) throws GeneralServiceException {
        String collectionName = "logistica";
        try {



            logistica.setFechaRegistro(LocalDateTime.now());
            //} else {
            logistica.setFechaEntrega(LocalDateTime.now());
            //}
            /**
             * Programación funcional: Creación de un optional para un objeto no nulo. Se utiliza la Api de Stream, nos permite realizar
             * operaciones de tipo filtro/mapeo/reducción sobre colecciones de datos de forma secuencial o paralela.
             * Ver info (https://www.oracle.com/lad/technical-resources/articles/java/expresiones-lambda-api-stream-java-part2.html)
             */
            return Optional.of(iLogisticaRepository.save(iLogisticaMapper.toData(logistica)))
                    .map(iLogisticaMapper::toModel).orElseThrow(ValidateServiceException::new);

        } catch (Exception ex) {
            throw new ValidateServiceException(ex.getMessage(), ex);
        }
    }

    /** Método encargado de listar Logistica
     * @return lista de objetos Service
     * @throw Exception si ocurre un error durante el proceso
     * @autor
     */
    @Override
    public List<Logistica> findAll() {

        return Optional.of(iLogisticaRepository.findAll(Sort.by("code"))
                .stream().map(iLogisticaMapper::toModel).collect(Collectors.toList())).orElseThrow(ValidateServiceException::new);
    }

    @Override
    public Logistica findById(String id) {
        return iLogisticaRepository.findById(id)
                .map(iLogisticaMapper::toModel)
                .orElseThrow(() -> new ValidateServiceException("Logistica not found for id: " + id));
    }

    @Override
    public void deleteById(String id) {
        iLogisticaRepository.deleteById(id);
    }
}
