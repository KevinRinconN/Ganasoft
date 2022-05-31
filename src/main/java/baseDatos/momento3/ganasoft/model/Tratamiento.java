package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Tratamiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento implements Serializable {

    @Id
    private Integer id;
    private Integer mes;
    private String tipoTratamiento;
    private String descripcion;
    private Boolean sexo;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="tratamiento")
    private List<Trabajo> trabajos;


}
