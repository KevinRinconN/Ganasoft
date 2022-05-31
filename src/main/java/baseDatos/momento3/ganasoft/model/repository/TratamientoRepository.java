package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Trabajo;
import baseDatos.momento3.ganasoft.model.Tratamiento;
import baseDatos.momento3.ganasoft.model.repository.crud.TrabajoCrudRepository;
import baseDatos.momento3.ganasoft.model.repository.crud.TratamientoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TratamientoRepository {
    @Autowired
    private TratamientoCrudRepository tratamientoCrudRepository;

    public List<Tratamiento> getAll(){
        return (List<Tratamiento>) tratamientoCrudRepository.findAll();
    }

    public Optional<Tratamiento> getTratamiento(int id){
        return tratamientoCrudRepository.findById(id);
    }

    public Tratamiento save(Tratamiento tratamiento){
        return tratamientoCrudRepository.save(tratamiento);
    }

    public void delete(Tratamiento tratamiento){
        tratamientoCrudRepository.delete(tratamiento);
    }

    public void deleteById(Integer id){
        tratamientoCrudRepository.deleteById(id);
    }
}
