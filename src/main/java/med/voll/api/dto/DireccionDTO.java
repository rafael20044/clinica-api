package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.modelos.Direccion;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public record DireccionDTO(
        @NotBlank
        String calle,
        @NotBlank
        Integer numero,
        @NotBlank
        String complemento,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad
        
        ) {
    
    public DireccionDTO(Direccion d){
        this(d.getCalle(), d.getNumero(), d.getComplemento(), d.getDistrito(), d.getCiudad());
    }
    
}
