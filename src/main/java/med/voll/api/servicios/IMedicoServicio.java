package med.voll.api.servicios;

import java.util.List;
import java.util.Optional;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.entidades.Medico;


/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IMedicoServicio {
    
    public void guardar(MedicoDTO dto);
    
    public MedicoDTO buscar(Long id);
    
    public List<MedicoDTO> buscarTodos();
    
    public void borrar(Long id);
    
    public Optional<Medico> buscarEntidad(Long id);
}
