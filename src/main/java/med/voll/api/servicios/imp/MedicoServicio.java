package med.voll.api.servicios.imp;

import java.util.List;
import java.util.Optional;
import med.voll.api.entidades.Medico;
import med.voll.api.repositorio.MedicoRepositorio;
import med.voll.api.servicios.IMedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class MedicoServicio implements IMedicoServicio{
    
    @Autowired
    private MedicoRepositorio repositorio;

    @Override
    public void guardar(Medico medico) {
        repositorio.save(medico);
    }

    @Override
    public Optional<Medico> buscarPorID(Long id) {
        return repositorio.findById(id).or(null);
    }

    @Override
    public List<Medico> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public void borrar(Long id) {
        repositorio.deleteById(id);
    }
    
}
