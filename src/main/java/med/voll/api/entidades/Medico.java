package med.voll.api.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.modelos.Direccion;
import med.voll.api.modelos.Especialidad;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
    
    public Medico(MedicoDTO dto){
        this(dto.id(), dto.nombre(),dto.email(), dto.documento(), dto.especialidad(),
                new Direccion(dto.direccion()));
    }
}
