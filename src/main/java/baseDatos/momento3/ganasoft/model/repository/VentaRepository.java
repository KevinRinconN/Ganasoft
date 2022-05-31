package baseDatos.momento3.ganasoft.model.repository;

import baseDatos.momento3.ganasoft.model.Tratamiento;
import baseDatos.momento3.ganasoft.model.Venta;
import baseDatos.momento3.ganasoft.model.repository.crud.TratamientoCrudRepository;
import baseDatos.momento3.ganasoft.model.repository.crud.VentaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepository {
    @Autowired
    private VentaCrudRepository ventaCrudRepository;

    public List<Venta> getAll(){
        return (List<Venta>) ventaCrudRepository.findAll();
    }

    public Optional<Venta> getVenta(int id){
        return ventaCrudRepository.findById(id);
    }

    public Venta save(Venta venta){
        return ventaCrudRepository.save(venta);
    }

    public void delete(Venta venta){
        ventaCrudRepository.delete(venta);
    }

    public void deleteById(Integer id){
        ventaCrudRepository.deleteById(id);
    }
}
