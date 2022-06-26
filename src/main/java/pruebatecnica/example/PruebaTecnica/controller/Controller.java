package pruebatecnica.example.PruebaTecnica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pruebatecnica.example.PruebaTecnica.interfaceService.NaveEspacialService;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;

@RestController
@RequestMapping("/naves")
public class Controller {

    private final NaveEspacialService service;

    @Autowired
    public Controller(NaveEspacialService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Page<NaveEspacial>>Naves(
            @RequestParam(defaultValue = "", required = false) String q,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(required = false) Integer size
    ){
        return new ResponseEntity<>(service.listar(q, page, size), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> guardarNave(@RequestBody NaveEspacial naveEspacial){
        service.save(naveEspacial);
        return new ResponseEntity<>("Se registro de forma Satisfactoria", HttpStatus.CREATED);
    }

    @PostMapping ("/{id}/eliminar")
    public ResponseEntity<String> deleteNaveEspacial(@PathVariable Long id){
        try{
            service.delete(id);
            return new ResponseEntity<>("Nave Espacial Eliminada",HttpStatus.CREATED);
        }catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

}
