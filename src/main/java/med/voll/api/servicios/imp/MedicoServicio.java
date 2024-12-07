package med.voll.api.servicios.imp;

import java.util.List;
import java.util.Optional;
import med.voll.api.dto.DireccionDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.entidades.Medico;
import med.voll.api.modelos.Direccion;
import med.voll.api.repositorio.MedicoRepositorio;
import med.voll.api.servicios.IMedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
            Direccion d = new Direccion(dto.direccion().calle(), dto.direccion().numero(),
                    dto.direccion().complemento(), dto.direccion().distrito(), dto.direccion().ciudad());
            Medico m = new Medico(dto.id(), dto.nombre(), dto.email(), dto.documento(), dto.especialidad(),
                    d);
            repositorio.save(m);
        }
    }

    @Override
    public MedicoDTO buscar(Long id) {
        Optional<Medico> medicoBuscar = buscarEntidad(id);
        if (medicoBuscar.isPresent()) {
            Medico m = medicoBuscar.get();
            DireccionDTO direccion = new DireccionDTO(m.getDireccion().getCalle(), m.getDireccion().getNumero(),
                    m.getDireccion().getComplemento(), m.getDireccion().getDistrito(),
                    m.getDireccion().getCiudad());
            MedicoDTO dto = new MedicoDTO(m.getId(), m.getNombre(), m.getEmail(), m.getDocumento(),
                    m.getEspecialidad(), direccion);
            return dto;
        }
        return null;
    }

    @Override
    public List<MedicoDTO> buscarTodos() {
        return repositorio.findAll().stream().map(m -> new MedicoDTO(m.getId(), m.getNombre(), m.getEmail(),
                m.getDocumento(), m.getEspecialidad(), new DireccionDTO(m.getDireccion().getCalle(),
                m.getDireccion().getNumero(),
                m.getDireccion().getComplemento(), m.getDireccion().getDistrito(),
                m.getDireccion().getCiudad()))).toList();
    }

    @Override
    public void borrar(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<Medico> buscarEntidad(Long id) {
        return repositorio.findById(id).or(null);
    }

}
