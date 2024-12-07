package med.voll.api.repositorio;

import med.voll.api.entidades.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael Barragán Acevedo
 */
@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long>{

    public Page<Medico> findByEstaActivoTrue(Pageable paginacion);
    
//    @Query("SELECT m FROM Medico m WHERE m.estaActivo = true")
//    public Page<Medico> buscarActivos(Pageable p);
    
}
