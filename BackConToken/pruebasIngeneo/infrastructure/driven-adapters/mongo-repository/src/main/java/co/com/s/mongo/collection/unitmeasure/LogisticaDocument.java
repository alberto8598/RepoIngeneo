package co.com.s.mongo.collection.unitmeasure;

import java.time.LocalDateTime;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * logisticaDocument
 * Clase encargada de mapear el documento de la colección logistica a mongoDB
 * @autor
 */
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "logistica")
@Data
@Builder
public class LogisticaDocument {
    @Id
    private String id;
    private String tipoProducto;
    private Integer cantidadProducto;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaEntrega;
    private String puertoEntrega;
    private String placaVehiculo;
    private String numeroFlota;
    private String numeroGuia;
    private Integer precioEnvio;
       private Integer descuentoOtorgado;

}
