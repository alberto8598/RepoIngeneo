package co.com.s.model.unitmeasure;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class Logistica {

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

    /*



*/
}

