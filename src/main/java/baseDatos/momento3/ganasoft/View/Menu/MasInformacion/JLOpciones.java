package baseDatos.momento3.ganasoft.View.Menu.MasInformacion;

import baseDatos.momento3.ganasoft.View.Configuracion;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class JLOpciones extends JLabel {

    private JLabel iconoSuperior;
    private JLabel texto;
    private JLabel iconoInferior;


    public JLOpciones (String fondo,String iconoSuperior, String texto, Color colorTexto, String iconoInferior){

        this.setIcon(new ImageIcon(fondo));
        this.iconoSuperior = Configuracion.imagen(iconoSuperior,10,5,42,42);
        this.texto = Configuracion.texto(texto,13,47,150,30,20,colorTexto,SwingConstants.LEFT);
        this.iconoInferior = Configuracion.imagen(iconoInferior,133,43,38,36);


        this.add(this.iconoSuperior);
        this.add(this.texto);
        this.add(this.iconoInferior);
    }
}
