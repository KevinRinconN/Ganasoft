package baseDatos.momento3.ganasoft.View;

import baseDatos.momento3.ganasoft.View.bovinos.RegistrarBovino;
import baseDatos.momento3.ganasoft.View.panelControl.BotonControl;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class PrincipalPage extends JFrame {

    private JPanel panelControl;
    private PanelContenido panelContenido;
    private BotonControl bovino;
    private BotonControl tratamiento;
    private BotonControl registro;
    private BotonControl venta;
    private BotonControl cliente;
    private BotonControl etapa;

    private Tabla tabla;

    private JButton JB_Agregar;
    private JButton JB_Actualizar;

    private RegistrarBovino ventanaRegistroBovino;
    private InsertarDatos ventanaActualizar;

    private JPopupMenu opcionesBovino;
    private JMenuItem masInformacion;
    private JMenuItem añadirTratamiento;
    private JMenuItem añadirEvento;
    private JMenuItem añadirRegistro;



    public PrincipalPage (){

        // se define el tamaño de la ventana
        setSize (1237, 689);
        // Se define la operacion cuando se cierra la ventana (terminar la ejecucion)
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // se define le titulo
        setTitle ("Ganasoft");
        // se define su localizacion (centro)
        setLocationRelativeTo (null);


        // se crea el metodo donde se inicializaran los componentes
        panelPrincipal ();
    }

    public void panelPrincipal(){
        // Creacion de panel pricipal
        JPanel panel = new JPanel ();
        // Se quita el layout
        panel.setLayout(null);
        // Se define el color
        panel.setBackground(new Color(235, 235, 235));
        // Añadir panel
        this.getContentPane().add(panel);



        //***********************************Panel Control ****************************************
        panelControl = new JPanel();
        panelControl.setBounds(0,0,299,649);
        panelControl.setBackground(new Color(235,235,235));
        panelControl.setLayout(null);

        bovino = new BotonControl("Bovinos", "bovinoIconoOprimido.png");
        bovino.setBounds(20,130,280,52);
        bovino.aparienciaOprimido();
        tratamiento = new BotonControl("Tratamiento", "tratamientoIcono.png");
        tratamiento.setBounds(20,200,280,52);
        registro = new BotonControl("Registro", "registroIcono.png");
        registro.setBounds(20,270,280,52);
        venta = new BotonControl("Venta", "ventaIcono.png");
        venta.setBounds(20,340,280,52);
        cliente = new BotonControl("Cliente", "clienteIcono.png");
        cliente.setBounds(20,410,280,52);
        etapa = new BotonControl("Etapa", "etapaIcono.png");
        etapa.setBounds(20,480,280,52);


        panelControl.add(bovino);
        panelControl.add(tratamiento);
        panelControl.add(registro);
        panelControl.add(venta);
        panelControl.add(cliente);
        panelControl.add(etapa);

        //***********************************Panel Contenido *************************************+*

        panelContenido = new PanelContenido("panelContenido.png");
        panelContenido.setBounds(299,0,938,648);
        panelContenido.setLayout(null);


        tabla = new Tabla();

        JScrollPane scroll = new JScrollPane (tabla,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Se define su tamaño
        scroll.setBounds(60, 140, 820, 350);
        // Se quita los bordes
        scroll.setBorder(null);
        scroll.setOpaque(false);


        ventanaRegistroBovino = new RegistrarBovino(this);
        ventanaActualizar = new InsertarDatos();

        JB_Agregar = Configuracion.boton("agregar.png", "agregarSeleccionado.png", "agregarOprimido.png", 80, 550, 144, 38);
        JB_Agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventanaRegistroBovino.setVisible(true);
            }
        });
        JB_Actualizar = Configuracion.boton("agregar.png", "agregarSeleccionado.png", "agregarOprimido.png", 260, 550, 144, 38);
        JB_Actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ventanaActualizar.setVisible(true);
            }
        });


        //*************************POPUP MENU ******************************
        opcionesBovino = new JPopupMenu();
        masInformacion = new JMenuItem("    Mas informacion..");
        añadirEvento = new JMenuItem("    Añadir evento");
        añadirRegistro = new JMenuItem("    Añadir Registro");
        añadirTratamiento = new JMenuItem("    Añadir tratamiento");

        opcionesBovino.setBorderPainted(false);
        opcionesBovino.setOpaque(true);
        opcionesBovino.setBackground(new Color(155,197,129));
        masInformacion.setOpaque(true);
        masInformacion.setBackground(new Color(155,197,129));
        añadirEvento.setBackground(new Color(155,197,129));
        añadirRegistro.setBackground(new Color(155,197,129));
        añadirTratamiento.setBackground(new Color(155,197,129));
        masInformacion.setForeground(new Color(226,240,217));
        añadirEvento.setForeground(new Color(226,240,217));
        añadirRegistro.setForeground(new Color(226,240,217));
        añadirTratamiento.setForeground(new Color(226,240,217));
        opcionesBovino.add(masInformacion);
        opcionesBovino.add(añadirEvento);
        opcionesBovino.add(añadirRegistro);
        opcionesBovino.add(añadirTratamiento);


        //*******************************************

        panelContenido.add(JB_Agregar);
        panelContenido.add(scroll);
        panelContenido.add(Configuracion.imagen("informacionBovino.png",60,80,790,56));


        panel.add(Configuracion.texto("Menu",50,30,100,50,30,new Color(0,0,0),SwingConstants.LEFT,"Rubik"));
        panel.add(panelControl);
        panel.add(panelContenido);

    }
}
