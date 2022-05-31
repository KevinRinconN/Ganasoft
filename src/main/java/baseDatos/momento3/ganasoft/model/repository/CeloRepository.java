package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Celo;
import baseDatos.momento3.ganasoft.model.repository.crud.CeloCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CeloRepository {
    @Autowired
    private CeloCrudRepository celoCrudRepository;

    public List<Celo> getAll(){
        return (List<Celo>) celoCrudRepository.findAll();
    }

    public Optional<Celo> getCelo(int id){
        return celoCrudRepository.findById(id);
    }

    public Celo save(Celo celo){
        return celoCrudRepository.save(celo);
    }

    public void delete(Celo celo){
        celoCrudRepository.delete(celo);
    }

    public void deleteById(Integer id){
        celoCrudRepository.deleteById(id);
    }

}
