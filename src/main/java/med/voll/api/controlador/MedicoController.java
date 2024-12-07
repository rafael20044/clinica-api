package med.voll.api.controlador;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.Optional;
import med.voll.api.dto.MedicoActualizar;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.servicios.imp.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Barragán Acevedo
 */

@RestController
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    private MedicoServicio servicio;
    
    @GetMapping("/buscarTodos")
    public Page<MedicoDTO> buscarTodos(Pageable paginacion){
        return servicio.buscarTodos(paginacion);
    }
    
    @GetMapping("/buscar/{id}")
    public Optional<MedicoDTO> buscarMedico(@PathVariable Long id){
        return servicio.buscar(id);
    }
    
    @PutMapping("/actualizar")
    @Transactional
    public void actualizar(@RequestBody @Valid MedicoActualizar actualizar){
        servicio.actualizar(actualizar);
    }
    
    @DeleteMapping("/borrar/{id}")
    @Transactional
    public void borrarMedico(@PathVariable Long id){
        servicio.borrar(id);
    }
    
    @DeleteMapping("/borrarLogico/{id}")
    @Transactional
    public void borrarLogico(@PathVariable Long id){
        servicio.borrarLogico(id);
    }
}
