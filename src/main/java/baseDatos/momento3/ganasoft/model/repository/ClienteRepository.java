package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Cliente;
import baseDatos.momento3.ganasoft.model.repository.crud.ClienteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return clienteCrudRepository.findById(id);
    }

    public Cliente save(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }

    public void delete(Cliente cliente){
        clienteCrudRepository.delete(cliente);
    }

    public void deleteById(Integer id){
        clienteCrudRepository.deleteById(id);
    }
}
