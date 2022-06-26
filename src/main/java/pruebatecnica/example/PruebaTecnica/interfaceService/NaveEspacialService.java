package pruebatecnica.example.PruebaTecnica.interfaceService;

import org.springframework.data.domain.Page;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;

import java.util.List;
import java.util.Optional;


public interface NaveEspacialService {
    public Page<NaveEspacial> listar(String query, Integer page, Integer size);
    public Optional<NaveEspacial> listarId(Long id);
    public List<NaveEspacial> findByName(String nombre);
    public void save(NaveEspacial N);
    public void delete(Long id);
    public void modificarNaveEspacial(NaveEspacial naveEspacial, Long id);


}
