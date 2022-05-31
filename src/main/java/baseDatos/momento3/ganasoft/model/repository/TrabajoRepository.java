package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Etapa;
import baseDatos.momento3.ganasoft.model.Trabajo;
import baseDatos.momento3.ganasoft.model.repository.crud.EtapaCrudRepository;
import baseDatos.momento3.ganasoft.model.repository.crud.TrabajoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TrabajoRepository {
    @Autowired
    private TrabajoCrudRepository trabajoCrudRepository;

    public List<Trabajo> getAll(){
        return (List<Trabajo>) trabajoCrudRepository.findAll();
    }

    public Optional<Trabajo> getTrabajo(int id){
        return trabajoCrudRepository.findById(id);
    }

    public Trabajo save(Trabajo trabajo){
        return trabajoCrudRepository.save(trabajo);
    }

    public void delete(Trabajo trabajo){
        trabajoCrudRepository.delete(trabajo);
    }

    public void deleteById(Integer id){
        trabajoCrudRepository.deleteById(id);
    }

}
