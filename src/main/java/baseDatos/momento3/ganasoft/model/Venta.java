package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta implements Serializable {

    @Id
    private Integer id;
    private String fecha;
    private Double valorCompra;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "venta")
    private List<Animal> animal;


    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;




}
