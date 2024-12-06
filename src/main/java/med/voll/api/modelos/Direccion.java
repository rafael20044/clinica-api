package med.voll.api.modelos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Direccion {
    
    private String calle;
    private Integer numero;
    private String complemento;
    private String distrito;
    private String ciudad;
    
}
