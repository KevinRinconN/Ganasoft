package baseDatos.momento3.ganasoft.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Animal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String rasgoDistintivo;
    private String sexo;
    private String raza;
    private String marca;

    public Animal (String fecha, String rasgoDistintivo, String sexo, String raza){
        this.fecha = fecha;
        this.rasgoDistintivo = rasgoDistintivo;
        this.sexo = sexo;
        this.raza = raza;
    }
    public Animal (String fecha,String rasgoDistintivo, String sexo, String raza,String marca, Animal padre, Animal madre){
        this.fecha = fecha;
        this.rasgoDistintivo = rasgoDistintivo;
        this.sexo = sexo;
        this.raza = raza;
        this.marca = marca;
        this.padre = padre;
        this.madre = madre;
    }

    @ManyToOne
    @JoinColumn(name = "idPadre")
    private Animal padre;

    @ManyToOne
    @JoinColumn(name = "idMadre")
    private Animal madre;


    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;


    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="padre")
    private List<Animal> desendenciaPadre;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="madre")
    private List<Animal> desendenciaMadre;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "animal")
    private List<Celo> celos;


    @ManyToMany
    @JoinTable(name = "Evento",joinColumns = @JoinColumn(name = "animalId"), inverseJoinColumns = @JoinColumn(name = "trabajoId"))
    private List<Trabajo> trabajo;



}
