package co.com.s.mongo.mapper.unitmeasure;

import co.com.s.model.unitmeasure.Logistica;
import co.com.s.mongo.collection.unitmeasure.LogisticaDocument;
import org.mapstruct.Mapper;

/** Interface que permite generar el codigo con mapstruct, cuando se compila el proyecto.
 * @return mapper
 * @autor
 */
@Mapper(componentModel = "spring")
public interface ILogisticaMapper {

    /** Método encargado de convertir objeto del tipo LogisticaDocument a un objeto del tipo Logistica
     * @return objeto tipo logistica
     * @autor
     */
    Logistica toModel(LogisticaDocument logisticaDocument);

    /** Método encargado de convertir objeto del tipo UnitMeasure a un objeto del tipo UnitMeasureDocument
     * @return objeto tipo UnitMeasureDocument
     * @autor
     */
    LogisticaDocument toData(Logistica logistica);
}
