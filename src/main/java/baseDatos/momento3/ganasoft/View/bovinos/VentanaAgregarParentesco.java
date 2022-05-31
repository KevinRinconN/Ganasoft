package baseDatos.momento3.ganasoft.View.bovinos;

import baseDatos.momento3.ganasoft.View.Configuracion;
import baseDatos.momento3.ganasoft.View.PanelContenido;
import baseDatos.momento3.ganasoft.View.Tabla;
import lombok.Data;

import javax.swing.*;

@Data
public class VentanaAgregarParentesco extends JDialog {

    private PanelContenido panelContenido;
    private Tabla tabla;
    private String sexo;
    private JButton jb_Agregar;


    public VentanaAgregarParentesco (JDialog ventana){
        super(ventana, true);

        setSize (890, 489);
        setLocationRelativeTo (null);
        panelPrincipal ();
    }

    public void panelPrincipal (){
        panelContenido = new PanelContenido("panelContenido.png");

        panelContenido.setLayout(null);
        this.getContentPane().add(panelContenido);

        tabla = new Tabla();

        JScrollPane scroll = new JScrollPane (tabla,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Se define su tamaño
        scroll.setBounds(20, 20, 820, 350);
        // Se quita los bordes
        scroll.setBorder(null);
        scroll.setOpaque(false);

        jb_Agregar = Configuracion.boton("agregar.png", "agregarSeleccionado.png", "agregarOprimido.png", 40, 380, 144, 38);


        panelContenido.add(scroll);
        panelContenido.add(jb_Agregar);

    }

}
