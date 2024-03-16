package co.com.s.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * UserDocument
 * Clase encargada de mapear el documento de la colección usuario a mongoDB
 * * @autor
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class User {
    private String id;
    private Integer code;
    private String name;
    private String lastName;
    private String company;
    private String email;
    private String password;
    private String confirmPassword;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
}
