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
import med.voll.api.dto.MedicoActualizar;
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
    private Boolean estaActivo;
    
    public Medico(MedicoDTO dto){
        this.nombre = dto.nombre();
        this.email = dto.email();
        this.documento = dto.documento();
        this.especialidad = dto.especialidad();
        this.direccion = new Direccion(dto.direccion());
        this.estaActivo = true;
    }
    
    public void actualizar(MedicoActualizar actualizar){
        
        if (actualizar.nombre() != null) {
            this.nombre = actualizar.nombre();
        }
        if (actualizar.documento()!= null) {
            this.documento = actualizar.documento();
        }
        if (actualizar.direccion()!= null) {
            this.direccion = direccion.actualizar(actualizar.direccion());
        }
    }
}
