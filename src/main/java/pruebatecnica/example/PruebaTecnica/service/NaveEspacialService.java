package pruebatecnica.example.PruebaTecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;
import pruebatecnica.example.PruebaTecnica.repository.NaveEspacialRepository;

import java.util.List;
import java.util.Optional;


@Service
public class NaveEspacialService implements pruebatecnica.example.PruebaTecnica.interfaceService.NaveEspacialService {

    @Autowired
    private NaveEspacialRepository _naveRepository;


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

    @Override
    public Optional<NaveEspacial> listarId(Long id) {
        return _naveRepository.findById(id);
    }

    @Override
    public List<NaveEspacial> findByName(String nombre) {
        return _naveRepository.findNaveEspacialByName(nombre);
    }

    @Override
    public void save(NaveEspacial NaveEspacial) {
       _naveRepository.save(NaveEspacial);
    }

    @Override
    public void delete(Long id) {
        _naveRepository.deleteById(id);
    }

    @Override
    public void modificarNaveEspacial(NaveEspacial naveEspacial, Long id) {
        Optional<NaveEspacial> navesEspaciales = _naveRepository.findById(id);

        if (navesEspaciales.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esta Nave Espacial no Existe");
        }

        List<NaveEspacial> searchN = _naveRepository.findNaveEspacialByName(naveEspacial.getName());
        NaveEspacial naveUpdate = navesEspaciales.get();

        if (!searchN.isEmpty()) {
            if (naveUpdate.getName().equals(naveEspacial.getName())) {
                if (searchN.get(0).getName().equals(naveEspacial.getName())) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Esta Nave Espacial ya Existe");
                }
            }
        }

        naveUpdate.setName(naveEspacial.getName());
        naveUpdate.setCountry(naveEspacial.getCountry());
        naveUpdate.setMision(naveEspacial.getMision());
        naveUpdate.setCombustible(naveEspacial.getCombustible());
        naveUpdate.setTipe(naveEspacial.getTipe());
        naveUpdate.setWeigth(naveEspacial.getWeigth());
        naveUpdate.setYearOpen(naveEspacial.getYearOpen());
        naveUpdate.setYearClose(naveEspacial.getYearClose());

    }
}
