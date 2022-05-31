package baseDatos.momento3.ganasoft.View;
import lombok.Data;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Data
public class InsertarDatos extends JFrame {
    /**
     * Boton agregar los datos
     */
    private JButton JB_Agregar;
    /**
     * Boton de cancelar
     */
    private JButton JB_Cancelar;
    /**
     * JTextField para el nombre del producto
     */
    private JTextField JTRasgoDistintivo;
    /**
     * JTextFielf para el precio del producto
     */
    private JTextField JTRaza;
    /**
     * JTextField para el inventario del producto
     */
    private JTextField JTEtapa;
    private JTextField JTSexo;



    public InsertarDatos (){
        // Se define el tamaño de la ventana
        setSize (459, 410);
        // se define su operacion al cerrar
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /// Se define el titulo
        setTitle ("Insertar Datos");
        // se define la localizacion de la ventana (Centro)
        setLocationRelativeTo (null);

        // Se instancia la funcion para incializar los elementos
        inicializarComponentes ();
    }

    public void inicializarComponentes (){

        // Creacion de panel pricipal
        JPanel panel = new JPanel ();
        // Se quita el layout
        panel.setLayout(null);
        // Se define el color
        panel.setBackground(new Color (255,255,255));
        // Añadir panel
        this.getContentPane().add(panel);


        // Se añade la imagen del encabezado
        panel.add(Configuracion.imagen("insertar.png", 10, 10, 439, 30));

        Color colorTexto = new Color (127,127,127);
        Color color = new Color (217,217,217);
        // Se añade el texto nombre
        panel.add(Configuracion.texto("Rasgo distintivo ", 60, 55, 200, 20, 20,colorTexto));
        // Se añade la caja de texto del nombre
        JTRasgoDistintivo = Configuracion.cajaTexto(60,85, 160, 30, color, colorTexto);

        panel.add(Configuracion.texto("Sexo ", 230, 55, 100, 20, 20,colorTexto));
        // Se añade la caja de texto del nombre
        JTSexo = Configuracion.cajaTexto(230,85, 150, 30, color, colorTexto);


        // Se añade el texto de precio
        panel.add(Configuracion.texto("Raza ", 60, 130, 100, 20, 20,colorTexto));
        // Se añade la caja de texto de precio
        JTRaza = Configuracion.cajaTexto(60, 165, 320, 30, color, colorTexto);

        // Se añade el texto de inventario
        panel.add(Configuracion.texto("Etapa ", 60, 210, 150, 20, 20, colorTexto));
        // Se añade la caja de texto de inventario
        JTEtapa = Configuracion.cajaTexto(60, 240, 320, 30, color, colorTexto);

        // Se crea el boton para agregar o actualizar los productos
        JB_Agregar = Configuracion.boton("aceptar.png", "aceptarSeleccionado.png", "aceptarOprimido.png", 60, 300, 144, 37);



        // Se crea el boton de cancelar
        JB_Cancelar = Configuracion.boton("cancelar.png", "cancelarSeleccionado.png", "cancelarOprimido.png", 240, 300, 144, 38);
        // Se añade su accion
        JB_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // se oculta la ventana
                definirVisibilidad (false);

            }
        });

        // se añade el boton agregar al panel principal
        panel.add(JB_Agregar);
        // se añade el boton cancelar al panel principal
        panel.add(JB_Cancelar);
        // se añade la caja de texto inventario al panel principal
        panel.add(JTEtapa);
        // se añade la caja de texto nombre al panel principal
        panel.add(JTRasgoDistintivo);
        // se añade la caja de texto precio al panel principal
        panel.add(JTRaza);
        panel.add(JTSexo);
    }

    /**
     * Borra el texto de todos los JTextField
     */
    public void borrarTexto (){
        JTRasgoDistintivo.setText("");
        JTRaza.setText("");
        JTEtapa.setText("");
    }
    public void definirVisibilidad (boolean visible){
        this.setVisible(visible);
    }
}
