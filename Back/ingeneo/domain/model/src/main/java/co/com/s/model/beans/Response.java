package co.com.s.model.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {
    private boolean ok;
    private Integer codigo;
    private String mensaje;
    private BodyResponse<T> cuerpo;


}
