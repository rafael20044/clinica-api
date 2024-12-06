package med.voll.api.repositorio;

import med.voll.api.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long>{
}
