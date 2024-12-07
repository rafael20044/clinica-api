package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public record MedicoActualizar (
        @NotNull
        Long id,
        String nombre, 
        String documento, 
        DireccionDTO direccion) {
    
}
