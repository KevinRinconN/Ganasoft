package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Cliente;
import baseDatos.momento3.ganasoft.model.Etapa;
import baseDatos.momento3.ganasoft.model.repository.crud.ClienteCrudRepository;
import baseDatos.momento3.ganasoft.model.repository.crud.EtapaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EtapaRepository {
    @Autowired
    private EtapaCrudRepository etapaCrudRepository;

    public List<Etapa> getAll(){
        return (List<Etapa>) etapaCrudRepository.findAll();
    }

    public Optional<Etapa> getEtapa(int id){
        return etapaCrudRepository.findById(id);
    }

    public Etapa save(Etapa etapa){
        return etapaCrudRepository.save(etapa);
    }

    public void delete(Etapa etapa){
        etapaCrudRepository.delete(etapa);
    }

    public void deleteById(Integer id){
        etapaCrudRepository.deleteById(id);
    }
}
