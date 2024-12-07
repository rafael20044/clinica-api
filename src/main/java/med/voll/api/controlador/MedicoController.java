package med.voll.api.controlador;

import java.util.List;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.servicios.imp.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<MedicoDTO> buscarTodos(){
        return servicio.buscarTodos();
    }
}
