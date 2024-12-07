package med.voll.api.servicios.imp;

import java.util.Optional;
import med.voll.api.dto.MedicoActualizar;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.entidades.Medico;
import med.voll.api.repositorio.MedicoRepositorio;
import med.voll.api.servicios.IMedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Service
public class MedicoServicio implements IMedicoServicio {

    @Autowired
    private MedicoRepositorio repositorio;

    @Override
    public void guardar(MedicoDTO dto) {
        Optional<Medico> medicoBuscar = buscarEntidad(dto.id());
        if (!medicoBuscar.isPresent()) {
            Medico m = new Medico(dto);
            repositorio.save(m);
        }
    }

    @Override
    public Optional<MedicoDTO> buscar(Long id) {
        return repositorio.findById(id).map(MedicoDTO::new);
    }

    @Override
    public Page<MedicoDTO> buscarTodos(Pageable paginacion) {
        return repositorio.findByEstaActivoTrue(paginacion).map(MedicoDTO::new);
    }

    @Override
    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<Medico> buscarEntidad(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public void actualizar(MedicoActualizar actualizar) {
        Optional<Medico> m = buscarEntidad(actualizar.id());
        if (m.isPresent()) {
            Medico medico = m.get();
            medico.actualizar(actualizar);
        }
    }

    @Override
    public void borrarLogico(Long id) {
        Optional<Medico> medico = buscarEntidad(id);
        if (medico.isPresent()) {
            Medico m = medico.get();
            m.setEstaActivo(false);
        }
    }

}
