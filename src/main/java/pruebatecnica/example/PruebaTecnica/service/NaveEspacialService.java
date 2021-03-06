package pruebatecnica.example.PruebaTecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pruebatecnica.example.PruebaTecnica.interfaces.INaveEspacial;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;
import pruebatecnica.example.PruebaTecnica.repository.NaveEspacialRepository;

import java.util.List;
import java.util.Optional;


@Service
public class NaveEspacialService implements pruebatecnica.example.PruebaTecnica.interfaceService.NaveEspacialService {

    //Implementacion de los servicios

    @Autowired
    private NaveEspacialRepository _naveRepository;
    private INaveEspacial _naveRepository2;


    //Metodo Listar
    @Override
    public Page<NaveEspacial> listar(String query, Integer page, Integer size) {
        long countNaves = _naveRepository.count();
        int sizeNotNull = size == null ? Math.toIntExact(countNaves) : size;

        Pageable pageable = PageRequest.of(page, sizeNotNull);
        if (!query.equals("") ) {
            return _naveRepository.navesFilter(query, pageable);
        } else {
            return _naveRepository.navesFilter(query, pageable);
        }

    }


    //Metodo Buscar por ID
    @Override
    public Optional<NaveEspacial> listarId(Long id) {
        return _naveRepository.findById(id);
    }


    //Metodo Buscar por Nombre
    @Override
    public List<NaveEspacial> findByName(String nombre) {
        return _naveRepository.findNaveEspacialByName(nombre);
    }


    //Metodo Guardar
    @Override
    public void save(NaveEspacial NaveEspacial) {
       _naveRepository.save(NaveEspacial);
    }

    //Metodo Eliminar
    @Override
    public void delete(Long id) {
        _naveRepository.deleteById(id);
        System.out.println(id);
    }

    //Metodo Modificar
    @Override
    public void modificarNaveEspacial(NaveEspacial naveEspacial, Long id) {
        Optional<NaveEspacial> navesEspaciales = _naveRepository.findById(id);

        if (navesEspaciales.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta Nave Espacial no Existe");
        }

        naveEspacial.setId(id);
        _naveRepository.save(naveEspacial);



    }
}
