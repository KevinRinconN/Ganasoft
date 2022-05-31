package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Trabajo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trabajo implements Serializable {

    @Id
    private Integer id;
    private String fecha;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idTratamiento")
    private Tratamiento tratamiento;

    @ManyToMany(mappedBy = "trabajo")
    private List<Animal> animal;


}
