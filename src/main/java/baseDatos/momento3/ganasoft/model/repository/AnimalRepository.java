package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Animal;
import baseDatos.momento3.ganasoft.model.repository.crud.AnimalCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimalRepository {

    @Autowired
    private AnimalCrudRepository animalcrudRepository;

    public List<Animal> getAll(){
        return (List<Animal>) animalcrudRepository.findAll();
    }

    public Optional<Animal> getAnimal(Long id){
        return animalcrudRepository.findById(id);
    }

    public Animal save(Animal animal){
        return animalcrudRepository.save(animal);
    }

    public void delete(Animal animal){
        animalcrudRepository.delete(animal);
    }

    public void deleteById(Long id){
        animalcrudRepository.deleteById(id);
    }

    public List<Animal> getByRaza(String raza){
        return animalcrudRepository.findByRaza(raza);
    }

    public List<Animal> getBySexo (String sexo){
        return animalcrudRepository.findBySexo(sexo);
    }

    public Optional<Animal> rasgoDistintivo (String rasgoDistintivo){
        return animalcrudRepository.findByRasgoDistintivo(rasgoDistintivo);
    }
}
