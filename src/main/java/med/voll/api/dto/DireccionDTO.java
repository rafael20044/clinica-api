package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;

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
    
}
