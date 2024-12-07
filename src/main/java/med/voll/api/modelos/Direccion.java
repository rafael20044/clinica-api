package med.voll.api.modelos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DireccionDTO;

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
    
    public Direccion(DireccionDTO dto){
        this(dto.calle(), dto.numero(), dto.complemento(), dto.distrito(), dto.ciudad());
    }
    
}
