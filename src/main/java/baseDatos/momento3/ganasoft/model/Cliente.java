package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {

    @Id
    private Integer id;
    private String nombre;
    private String corre;
    private String numero;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cliente")
    private List<Venta> venta;

}
