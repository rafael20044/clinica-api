package med.voll.api.servicios;

import java.util.List;
import java.util.Optional;
import med.voll.api.entidades.Medico;

/**
 *
 * @author Rafael Barragán Acevedo
 */
public interface IMedicoServicio {
    
    public void guardar(Medico medico);
    
    public Optional<Medico> buscarPorID(Long id);
    
    public List<Medico> buscarTodos();
    
    public void borrar(Long id);
}
