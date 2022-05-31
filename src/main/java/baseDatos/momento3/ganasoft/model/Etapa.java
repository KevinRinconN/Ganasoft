package baseDatos.momento3.ganasoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Etapa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etapa implements Serializable {

    @Id
    private Integer id;
    private Integer mesInicial;
    private Integer mesFinal;
    private String descripcion;
    private Boolean sexo;

}
