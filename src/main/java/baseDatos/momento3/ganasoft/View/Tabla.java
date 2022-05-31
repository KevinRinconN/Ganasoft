package baseDatos.momento3.ganasoft.View;

import baseDatos.momento3.ganasoft.View.bovinos.InterfazTabla;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Tabla extends JPanel {
    private List<InterfazTabla> interfazTablas;
    private Integer idElementoSeleccionado;


    public Tabla (){
        interfazTablas = new ArrayList<InterfazTabla>();
        // Se define el color del panel
        setBackground(new Color(255, 255, 255));
        // se quita el layout
        setLayout(null);
    }

    public void agregarElemento (InterfazTabla interfazTabla){
        interfazTablas.add(interfazTabla);
        this.add(interfazTabla);
        ordenarTabla ();
    }

    public void ordenarTabla (){
        int posicionVertical = 0;
        for (InterfazTabla elemento:
             interfazTablas) {
            elemento.setBounds(20,posicionVertical,765,41);
            posicionVertical +=50;
        }
        this.setPreferredSize(new Dimension(820,posicionVertical));
        this.updateUI();
    }

    public void unicaSeleccionada(InterfazTabla elementoSeleccionado) {

        for (InterfazTabla elemento : interfazTablas) {
            if (!(elementoSeleccionado.getId() == elemento.getId())) {
                elemento.aparienciaPredeterminada();
                elemento.getIdTexto().setText(elemento.getIdTexto().getText());
                elemento.setSeleccionado(false);


            }else{
                idElementoSeleccionado = elemento.getId();
            }
        }

    }

}
