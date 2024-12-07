package med.voll.api.servicios;

import java.util.Optional;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.entidades.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IMedicoServicio {
    
    public void guardar(MedicoDTO dto);
    
    public MedicoDTO buscar(Long id);
    
    public Page<MedicoDTO> buscarTodos(Pageable paginacion);
    
    public void borrar(Long id);
    
    public Optional<Medico> buscarEntidad(Long id);
}
