package baseDatos.momento3.ganasoft.View.panelControl;

import baseDatos.momento3.ganasoft.View.Configuracion;

import javax.swing.*;
import java.awt.*;

public class BotonControl extends JLabel {

    private ImageIcon botonControl;
    private ImageIcon botonControlSeleccionado;
    private ImageIcon botonControlOprimido;

    private JLabel texto;
    private JLabel icono;

    public BotonControl (String texto, String icono){
        this.texto = Configuracion.texto(texto,90,0,200,50,20,
                new Color(127,127,127),SwingConstants.LEFT,"Aileron");

        this.icono = Configuracion.imagen(icono,30,3,44,44);

        botonControl = new ImageIcon("botonControl.png");
        botonControlSeleccionado = new ImageIcon("botonControlSeleccionado.png");
        botonControlOprimido = new ImageIcon("botonControlOprimido.png");

        aparienciaDefecto ();
        this.add(this.texto);
        this.add(this.icono);
    }

    public void aparienciaDefecto (){
        this.texto.setForeground(new Color(127,127,127));
        this.setIcon(botonControl);

    }
    public void aparienciaSeleccionado (){
        this.texto.setForeground(new Color(127,127,127));
        this.setIcon(botonControlSeleccionado);
    }
    public void aparienciaOprimido (){
        this.texto.setForeground(new Color(84,130,53));
        this.setIcon(botonControlOprimido);
    }


}
