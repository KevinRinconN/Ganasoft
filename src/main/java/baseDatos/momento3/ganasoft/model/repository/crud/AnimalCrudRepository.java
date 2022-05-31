package baseDatos.momento3.ganasoft.model.repository.crud;

import baseDatos.momento3.ganasoft.model.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalCrudRepository extends CrudRepository<Animal,Long> {

    List<Animal> findBySexo(String sexo);
    List<Animal> findByRaza(String raza);
    Optional<Animal> findByRasgoDistintivo(String rasgoDistintivo);



}
