package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.entidades.Medico;
import med.voll.api.modelos.Especialidad;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public record MedicoDTO (   
        @NotBlank
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento,   
        @NotBlank
        Especialidad especialidad,
        @NotNull
        @Valid
        DireccionDTO direccion
        ){
    
    public MedicoDTO(Medico m){
        this(m.getId(), m.getNombre(), m.getEmail(), m.getDocumento(),m.getEspecialidad(), 
                new DireccionDTO(m.getDireccion()));
    }
}
