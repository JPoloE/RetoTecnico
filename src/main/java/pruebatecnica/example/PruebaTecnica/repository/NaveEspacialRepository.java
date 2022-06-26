package pruebatecnica.example.PruebaTecnica.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pruebatecnica.example.PruebaTecnica.model.NaveEspacial;

import java.util.List;
import java.util.Optional;

@Repository
public interface NaveEspacialRepository extends JpaRepository<NaveEspacial,Long> {
    @Query("SELECT N FROM NaveEspacial N WHERE N.name LIKE %:q%")
    @EntityGraph(value = "nave.graph",type = EntityGraph.EntityGraphType.LOAD)
    Page<NaveEspacial>navesFilter (String q, Pageable pageable);

    List<NaveEspacial> findNaveEspacialByName(String N);



}
