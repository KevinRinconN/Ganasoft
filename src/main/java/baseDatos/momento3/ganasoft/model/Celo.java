package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Celo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Celo implements Serializable {
    @Id
    private Integer id;
    private String fechaInicio;
    private String fechaAproximada;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="idAnimal")
    private Animal animal;

}
