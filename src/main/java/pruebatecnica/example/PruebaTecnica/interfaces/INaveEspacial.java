package pruebatecnica.example.PruebaTecnica.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;

@Repository
public interface INaveEspacial extends CrudRepository<NaveEspacial, Integer> {
}
